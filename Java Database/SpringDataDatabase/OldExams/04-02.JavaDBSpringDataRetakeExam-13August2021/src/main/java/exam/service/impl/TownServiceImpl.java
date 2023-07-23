package exam.service.impl;

import exam.model.dtos.TownImportRootDto;
import exam.model.entities.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class TownServiceImpl implements TownService {

    private static String TOWNS_FILE_PATH = "src/main/resources/files/xml/towns.xml";

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final TownRepository townRepository;

    public TownServiceImpl(ModelMapper modelMapper, XmlParser xmlParser,
                           ValidationUtil validationUtil, TownRepository townRepository) {
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.townRepository = townRepository;
    }


    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        TownImportRootDto townImportRootDto =
                xmlParser.fromFile(TOWNS_FILE_PATH, TownImportRootDto.class);

        townImportRootDto.getTowns()
                .stream()
                .filter(townImportDto -> {

                    boolean isValid = validationUtil.isValid(townImportDto);

                    Optional<Town> optionalTown = townRepository.findTownByName(townImportDto.getName());

                    if (optionalTown.isPresent()) {
                        isValid = false;
                    }


                    sb.append(isValid ? String.format("Successfully imported Town %s", townImportDto.getName())
                                    : "Invalid town")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(townImportDto -> modelMapper.map(townImportDto, Town.class))
                .forEach(townRepository::save);


        return sb.toString();
    }
}
