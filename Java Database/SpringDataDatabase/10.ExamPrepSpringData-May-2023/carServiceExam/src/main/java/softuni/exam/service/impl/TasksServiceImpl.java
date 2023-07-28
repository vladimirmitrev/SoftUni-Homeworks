package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskImportRootDto;
import softuni.exam.models.entity.*;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

// TODO: Implement all methods
@Service
public class TasksServiceImpl implements TasksService {
    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";

    private final TasksRepository tasksRepository;

    private final CarsRepository carsRepository;

    private final MechanicsRepository mechanicsRepository;
    private final PartsRepository partsRepository;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public TasksServiceImpl(TasksRepository tasksRepository, CarsRepository carsRepository,
                            MechanicsRepository mechanicsRepository, PartsRepository partsRepository,
                            ModelMapper modelMapper,
                            ValidationUtil validationUtil, XmlParser xmlParser) {
        this.tasksRepository = tasksRepository;
        this.carsRepository = carsRepository;
        this.mechanicsRepository = mechanicsRepository;
        this.partsRepository = partsRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return tasksRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        TaskImportRootDto taskImportRootDto =
                xmlParser.fromFile(TASKS_FILE_PATH, TaskImportRootDto.class);

        taskImportRootDto.getTasks()
                .stream()
                .filter(taskImportDto -> {

                    boolean isValid = validationUtil.isValid(taskImportDto);

                    Optional<Mechanic> optionalMechanic =
                            mechanicsRepository.findMechanicByFirstName(taskImportDto.getMechanic().getFirstName());

                    if (optionalMechanic.isEmpty()) {
                        isValid = false;
                    }


                    sb.append(isValid ? String.format("Successfully imported task %.2f",
                                    taskImportDto.getPrice())
                                    : "Invalid task")
                            .append(System.lineSeparator());

                    return isValid;


                })
                .map(taskImportDto -> {

                    Task task = modelMapper.map(taskImportDto, Task.class);

                    Optional<Mechanic> mechanic =
                            mechanicsRepository.findMechanicByFirstName(taskImportDto.getMechanic().getFirstName());

                    Optional<Car> car = carsRepository.findById(taskImportDto.getCar().getId());

                    Optional<Part> part = partsRepository.findById(taskImportDto.getPart().getId());

                    task.setMechanic(mechanic.get());

                    task.setCar(car.get());

                    task.setPart(part.get());

                    return task;

                })
                .forEach(tasksRepository::save);

        return sb.toString();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {

        StringBuilder sb = new StringBuilder();

        List<Task> taskList =
                tasksRepository.findByCar_CarTypeOrderByPriceDesc(CarType.coupe);

        taskList.forEach(task ->
                sb.append(String.format
                        ("Car %s %s with %dkm%n" +
                                        "-Mechanic: %s %s - task №%d:%n" +
                                        " --Engine: %.1f%n" +
                                        "---Price: %.2f$%n",
                                task.getCar().getCarMake(),
                                task.getCar().getCarModel(),
                                task.getCar().getKilometers(),
                                task.getMechanic().getFirstName(),
                                task.getMechanic().getLastName(),
                                task.getId(),
                                task.getCar().getEngine(),
                                task.getPrice())));

        return sb.toString();
    }
}
