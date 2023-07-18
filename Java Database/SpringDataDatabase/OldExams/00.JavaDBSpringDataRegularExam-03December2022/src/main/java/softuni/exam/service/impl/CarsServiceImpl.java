package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarImportRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class CarsServiceImpl implements CarsService {
    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";

    private final CarsRepository carsRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;


    @Autowired
    public CarsServiceImpl(CarsRepository carsRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.carsRepository = carsRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return carsRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        CarImportRootDto carImportRootDto =
                xmlParser.fromFile(CARS_FILE_PATH, CarImportRootDto.class);

        carImportRootDto.getCars()
                .stream()
                .filter(carImportDto -> {

                    boolean isValid = validationUtil.isValid(carImportDto);

                    Optional<Car> optionalCar = carsRepository.findCarByPlateNumber(carImportDto.getPlateNumber());


                    if (optionalCar.isPresent()) {
                        isValid = false;
                    }


                    sb.append(isValid ? String.format("Successfully imported car %s - %s",
                                    carImportDto.getCarMake(), carImportDto.getCarModel())
                                    : "Invalid car")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(carImportDto -> modelMapper.map(carImportDto, Car.class))
                .forEach(carsRepository::save);


        return sb.toString();
    }

    @Override
    public Car findCarById(Long id) {
        return carsRepository.findCarById(id);
    }
}
