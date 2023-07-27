package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.CarImportDto;
import softuni.exam.models.entities.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtilImpl;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private static String CARS_FILE_PATH = "src/main/resources/files/json/cars.json";

    private final ModelMapper modelMapper;
    private final ValidationUtilImpl validationUtil;

    private final Gson gson;
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(ModelMapper modelMapper, ValidationUtilImpl validationUtil,
                          Gson gson, CarRepository carRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.carRepository = carRepository;
    }

    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {

        StringBuilder sb = new StringBuilder();

        CarImportDto[] carImportDtos =
                gson.fromJson(readCarsFileContent(), CarImportDto[].class);

        Arrays.stream(carImportDtos)
                .filter(carImportDto -> {

                    boolean isValid = validationUtil.isValid(carImportDto);

                    sb.append(isValid ? String.format("Successfully imported car - %s - %s",
                                    carImportDto.getMake(), carImportDto.getModel())
                                    : "Invalid car")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(carImportDto -> modelMapper.map(carImportDto, Car.class))
                .forEach(carRepository::save);


        return sb.toString();
    }

    @Override
    @Transactional
    public String getCarsOrderByPicturesCountThenByMake() {

        StringBuilder sb = new StringBuilder();

        List<Car> carList = carRepository.getAllCarsOrderByPictureCount();

        carList.forEach(car ->
                sb.append(String.format("Car make - %s, model - %s%n" +
                                        "       Kilometers - %d%n" +
                                        "       Registered on - %s%n" +
                                        "       Number of pictures - %d%n",
                                car.getMake(), car.getModel(),
                                car.getKilometers(),
                                car.getRegisteredOn(),
                                car.getPictures().size()))
                        .append(System.lineSeparator()));


        return sb.toString();
    }
}
