package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

// TODO: Implement all methods
@Service
public class ConstellationServiceImpl implements ConstellationService {

    private static String CONSTELLATIONS_FILE_PATH = "src/main/resources/files/json/constellations.json";

    private final ConstellationRepository constellationRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    @Autowired
    public ConstellationServiceImpl(ConstellationRepository constellationRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.constellationRepository = constellationRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATIONS_FILE_PATH));
    }

    @Override
    public String importConstellations() throws IOException {

        StringBuilder sb = new StringBuilder();

        ConstellationImportDto[] constellationImportDtos =
                gson.fromJson(readConstellationsFromFile(), ConstellationImportDto[].class);

        Arrays.stream(constellationImportDtos)
                .filter(constellationImportDto -> {

                    boolean isValid = validationUtil.isValid(constellationImportDto);

                    Optional<Constellation> optionalConstellation =
                            constellationRepository.findByName(constellationImportDto.getName());

                    if(optionalConstellation.isPresent()) {
                        isValid = false;
                    }


                    sb.append(isValid ? String.format("Successfully imported constellation %s - %s",
                            constellationImportDto.getName(), constellationImportDto.getDescription())
                            : "Invalid constellation")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(constellationImportDto -> modelMapper.map(constellationImportDto, Constellation.class))
                .forEach(constellationRepository::save);


        return sb.toString();
    }
}
