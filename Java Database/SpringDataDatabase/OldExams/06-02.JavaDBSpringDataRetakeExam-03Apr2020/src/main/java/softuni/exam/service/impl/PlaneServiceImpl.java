package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PlaneImportDto;
import softuni.exam.models.dto.PlaneImportRootDto;
import softuni.exam.models.entities.Plane;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class PlaneServiceImpl implements PlaneService {

    private static String PLANES_FILE_PATH = "src/main/resources/files/xml/planes.xml";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    private final XmlParser xmlParser;

    private final PlaneRepository planeRepository;




    @Autowired
    public PlaneServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil,
                            XmlParser xmlParser, PlaneRepository planeRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.planeRepository = planeRepository;
    }

    @Override
    public boolean areImported() {
        return planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(PLANES_FILE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        PlaneImportRootDto planeImportRootDto =
                xmlParser.fromFile(PLANES_FILE_PATH, PlaneImportRootDto.class);


        planeImportRootDto.getPlanes()
                .stream()
                .filter(planeImportDto -> {

                    boolean isValid = validationUtil.isValid(planeImportDto);

                    Optional<Plane> optionalPlane =
                            planeRepository.findPlaneByRegisterNumber(planeImportDto.getRegisterNumber());

                    sb.append(isValid ? String.format("Successfully imported Plane %s",
                                    planeImportDto.getRegisterNumber())
                                    : "Invalid Plane")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(planeImportDto -> modelMapper.map(planeImportDto, Plane.class))
                .forEach(planeRepository::save);


        return sb.toString();
    }
}
