package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerImportRootDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

// TODO: Implement all methods
@Service
public class AstronomerServiceImpl implements AstronomerService {

    private static String ASTRONOMERS_FILE_PATH = "src/main/resources/files/xml/astronomers.xml";

    private final AstronomerRepository astronomerRepository;
    private final StarRepository starRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    @Autowired
    public AstronomerServiceImpl(AstronomerRepository astronomerRepository,
                                 StarRepository starRepository, ModelMapper modelMapper,
                                 ValidationUtil validationUtil, XmlParser xmlParser) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }


    @Override
    public boolean areImported() {
        return astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMERS_FILE_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        AstronomerImportRootDto astronomerImportRootDto =
                xmlParser.fromFile(ASTRONOMERS_FILE_PATH, AstronomerImportRootDto.class);

        astronomerImportRootDto.getAstronomers()
                .stream()
                .filter(astronomerImportDto -> {

                    boolean isValid = validationUtil.isValid(astronomerImportDto);


                    Optional<Astronomer> optionalAstronomer =
                            astronomerRepository.findByFirstNameAndLastName(astronomerImportDto.getFirstName(), astronomerImportDto.getLastName());

                    Optional<Star> optionalStar =
                            starRepository.findById(astronomerImportDto.getObservingStar());


                    if (optionalAstronomer.isPresent()) {
                        isValid = false;
                    }

                    if (optionalStar.isEmpty()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported astronomer %s %s - %.2f",
                                    astronomerImportDto.getFirstName(), astronomerImportDto.getLastName(),
                                    astronomerImportDto.getAverageObservationHours())
                                    : "Invalid astronomer")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(astronomerImportDto -> {

                    Astronomer astronomer = modelMapper.map(astronomerImportDto, Astronomer.class);

                    Optional<Star> observingStarId =
                            starRepository.findById(astronomerImportDto.getObservingStar());

                    astronomer.setObservingStar(observingStarId.get());

                    return astronomer;
                })
                .forEach(astronomerRepository::save);


        return sb.toString();
    }
}
