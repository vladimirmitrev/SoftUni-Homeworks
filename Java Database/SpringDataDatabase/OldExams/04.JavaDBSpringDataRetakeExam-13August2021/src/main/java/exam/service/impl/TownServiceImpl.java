package exam.service.impl;

import exam.model.dto.TownImportDto;
import exam.model.dto.TownImportRootDto;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class TownServiceImpl implements TownService {


    private static final String TOWNS_FILE_PATH = "src/main/resources/files/xml/towns.xml";
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    private final XmlParser xmlParser;


    @Autowired
    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
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

        TownImportRootDto importTownRootDto = xmlParser.fromFile(TOWNS_FILE_PATH, TownImportRootDto.class);

        importTownRootDto.getTowns()
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

    @Override
    public Town findTownByName(String townName) {

        return townRepository
                .findTownByName(townName)
                .orElse(null);
    }
}
