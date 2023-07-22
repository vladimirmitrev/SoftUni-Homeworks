package com.example.football.service.impl;

import com.example.football.models.dto.TeamImportDto;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private static String TEAMS_FILE_PATH = "src/main/resources/files/json/teams.json";

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    private final TownRepository townRepository;

    private final TeamRepository teamRepository;


    @Autowired
    public TeamServiceImpl(ModelMapper modelMapper, Gson gson,
                           ValidationUtil validationUtil, TownRepository townRepository,
                           TeamRepository teamRepository) {
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.townRepository = townRepository;
        this.teamRepository = teamRepository;
    }


    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAMS_FILE_PATH));
    }

    @Override
    public String importTeams() throws IOException {

        StringBuilder sb = new StringBuilder();

        TeamImportDto[] teamImportDtos =
                gson.fromJson(readTeamsFileContent(), TeamImportDto[].class);

        Arrays.stream(teamImportDtos)
                .filter(teamImportDto -> {

                    boolean isValid = validationUtil.isValid(teamImportDto);

                    Optional<Team> optionalTeam =
                            teamRepository.findTeamByName(teamImportDto.getName());

                    if (optionalTeam.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported Team %s - %d",
                                    teamImportDto.getName(), teamImportDto.getFanBase())
                                    : "Invalid Team")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(teamImportDto -> {

                    Team team = modelMapper.map(teamImportDto, Team.class);

                    Optional<Town> optionalTown = townRepository.findTownByName(teamImportDto.getTownName());

                    team.setTown(optionalTown.get());

                    return team;
                })
                .forEach(teamRepository::save);


        return sb.toString();
    }
}
