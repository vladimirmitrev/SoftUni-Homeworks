package com.example.football.service.impl;

import com.example.football.models.dto.TownImportDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;


@Service
public class TownServiceImpl implements TownService {

    private static String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(ModelMapper modelMapper, Gson gson,
                           ValidationUtil validationUtil, TownRepository townRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
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
    public String importTowns() throws IOException {

        StringBuilder sb = new StringBuilder();

        TownImportDto[] townImportDtos =
                gson.fromJson(readTownsFileContent(), TownImportDto[].class);

        Arrays.stream(townImportDtos)
                .filter(townImportDto -> {

                    boolean isValid = validationUtil.isValid(townImportDto);

                    Optional<Town> optionalTown = townRepository.findTownByName(townImportDto.getName());

                    if (optionalTown.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported Town %s - %d",
                                    townImportDto.getName(), townImportDto.getPopulation())
                                    : "Invalid Town")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(townImportDto -> modelMapper.map(townImportDto, Town.class))
                .forEach(townRepository::save);


        return sb.toString();
    }
}
