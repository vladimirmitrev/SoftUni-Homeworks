package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownImportDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

@Service
public class TownServiceImpl implements TownService {


    private static String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";

    private final ModelMapper modelMapper;

    private final Gson gson;
    private final TownRepository townRepository;

    private final ValidationUtil validationUtil;

    @Autowired
    public TownServiceImpl(ModelMapper modelMapper, Gson gson, TownRepository townRepository, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.townRepository = townRepository;
        this.validationUtil = validationUtil;
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

        TownImportDto[] townImportDtos =
                gson.fromJson(readTownsFileContent(), TownImportDto[].class);


        Arrays.stream(townImportDtos)
                .filter(townImportDto -> {
                    boolean isValid = validationUtil.isValid(townImportDto);


                    Optional<Town> optionalTown =
                            townRepository.findTownByTownName(townImportDto.getTownName());


                    if (optionalTown.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format(Locale.US, "Successfully imported town %s - %d",
                                    townImportDto.getTownName(), townImportDto.getPopulation())
                                    : "Invalid town")
                            .append(System.lineSeparator());


                    return isValid;

                })
                .map(townImportDto -> modelMapper.map(townImportDto, Town.class))
                .forEach(townRepository::save);


        return sb.toString();
    }
}
