package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownSeedDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class TownServiceImpl implements TownService {

    private static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";

    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
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
    public String importTowns() throws IOException {

        StringBuilder sb = new StringBuilder();

        TownSeedDto[] townSeedDtos = gson.fromJson(readTownsFileContent(), TownSeedDto[].class);


        Arrays.stream(townSeedDtos)
                .filter(townSeedDto -> {
                    boolean isValid = validationUtil.isValid(townSeedDto);

                    Optional<Town> townByName = townRepository.findByTownName(townSeedDto.getTownName());
                    if (townByName.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported town %s - %d",
                                    townSeedDto.getTownName(), townSeedDto.getPopulation())
                                    : "Invalid town")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(townSeedDto -> modelMapper.map(townSeedDto, Town.class))
                .forEach(townRepository::save);


        return sb.toString();
    }

    @Override
    public Town findByName(String town) {
        return townRepository
                .findByTownName(town)
                .orElse(null);
    }

    @Override
    public Town findByTownName(String townName) {
        Optional<Town> townByTownName = townRepository.findByTownName(townName);
        if (townByTownName.isEmpty()) {
            return null;
        }
        return townByTownName.get();
    }

}
