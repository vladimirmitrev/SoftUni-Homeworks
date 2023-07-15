package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PlaneImportRootDto;
import softuni.exam.models.entity.Plane;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TownService;
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


    private static final String PLANES_FILE_PATH = "src/main/resources/files/xml/planes.xml";
    private final PlaneRepository planeRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;


    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.planeRepository = planeRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
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

        PlaneImportRootDto planeImportRootDto = xmlParser.fromFile(PLANES_FILE_PATH, PlaneImportRootDto.class);

        planeImportRootDto.getPlanes()
                .stream()
                .filter(planeImportDto -> {
                    boolean isValid = validationUtil.isValid(planeImportDto);


                    Optional<Plane> optionalPlane = planeRepository.findPlaneByRegisterNumber(planeImportDto.getRegisterNumber());


                    if (optionalPlane.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported Plane %s", planeImportDto.getRegisterNumber())
                                    : "Invalid Plane")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(planeImportDto -> modelMapper.map(planeImportDto, Plane.class))
                .forEach(planeRepository::save);

        return sb.toString();
    }

    @Override
    public Plane findPlaneByRegisterNumber(String registerNumber) {
        return planeRepository
                .findPlaneByRegisterNumber(registerNumber)
                .orElse(null);
    }
}
