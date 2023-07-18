package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskImportRootDto;
import softuni.exam.models.entity.CarType;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Task;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.CarsService;
import softuni.exam.service.MechanicsService;
import softuni.exam.service.PartsService;
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
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    private final MechanicsService mechanicsService;
    private final PartsService partsService;
    private final CarsService carsService;
    private final MechanicsRepository mechanicsRepository;

    @Autowired
    public TasksServiceImpl(TasksRepository tasksRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, MechanicsService mechanicsService, PartsService partsService, CarsService carsService, MechanicsRepository mechanicsRepository) {
        this.tasksRepository = tasksRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.mechanicsService = mechanicsService;
        this.partsService = partsService;
        this.carsService = carsService;
        this.mechanicsRepository = mechanicsRepository;
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

                    Optional<Mechanic> optionalMechanic = mechanicsRepository
                            .findMechanicByFirstName(taskImportDto.getMechanic().getFirstName());

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

                    task.setMechanic(mechanicsService.findMechanicByFirstName(taskImportDto.getMechanic().getFirstName()));

                    task.setCar(carsService.findCarById(taskImportDto.getCar().getId()));

                    task.setPart(partsService.findPartById(taskImportDto.getPart().getId()));

                    return task;
                })
                .forEach(tasksRepository::save);


        return sb.toString();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {

        StringBuilder sb = new StringBuilder();

        List<Task> taskList = tasksRepository.findTaskByCar_CarTypeOrderByPriceDesc(CarType.coupe);


        taskList.forEach(task ->
                sb.append(String.format("Car %s %s with %dkm%n" +
                                "-Mechanic: %s %s - task №%d:%n" +
                                " --Engine: %.1f%n" +
                                "---Price: %.2f$%n",
                        task.getCar().getCarMake(),
                        task.getCar().getCarModel(),
                        task.getCar().getKilometers(),
                        task.getMechanic().getFirstName(), task.getMechanic().getLastName(),
                        task.getId(),
                        task.getCar().getEngine(),
                        task.getPrice())));


        return sb.toString();
    }
}
