package com.example.football.service.impl;

import com.example.football.models.dto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    private final XmlParser xmlParser;
    private final TownService townService;

    private final StatService statService;
    private final TeamService teamService;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, XmlParser xmlParser, TownService townService, StatService statService, TeamService teamService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.townService = townService;
        this.statService = statService;
        this.teamService = teamService;
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        PlayerSeedRootDto playerSeedRootDto =
                xmlParser.fromFile(PLAYERS_FILE_PATH, PlayerSeedRootDto.class);


        playerSeedRootDto.getPlayers()
                .stream()
                .filter(playerSeedDto -> {
                    boolean isValid = validationUtil.isValid(playerSeedDto);

                    Optional<Player> optionalPlayer = playerRepository.findByEmail(playerSeedDto.getEmail());

                    if (optionalPlayer.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid ? String.format("Successfully imported Player %s %s - %s",
                                    playerSeedDto.getFirstName(), playerSeedDto.getLastName(), playerSeedDto.getPosition())
                                    : "Invalid Player")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(playerSeedDto -> {
                    Player player = modelMapper.map(playerSeedDto, Player.class);

                    player.setTown(townService.findByName(playerSeedDto.getTown().getName()));
                    player.setTeam(teamService.findTeamByName(playerSeedDto.getTeam().getName()));
                    player.setStat(statService.findById(playerSeedDto.getStat().getStatId()));

                    return player;

                })
                .forEach(playerRepository::save);


        return sb.toString();
    }

    @Override
    public String exportBestPlayers() {

        StringBuilder sb = new StringBuilder();

        LocalDate after = LocalDate.of(1995, 01, 01);
        LocalDate before = LocalDate.of(2003, 01, 01);


        List<Player> playerList =
                playerRepository
                        .findAllByBirthDateAfterAndBirthDateBeforeOrderByStatShootingDescStatPassingDescStatEnduranceDescLastNameAsc(after, before);

        playerList.forEach(player -> {
            sb.append(String.format("Player - %s %s%n" +
                            "    Position - %s%n" +
                            "    Team - %s%n" +
                            "    Stadium - %s%n", player.getFirstName(), player.getLastName(),
                    player.getPosition(), player.getTeam().getName(),
                    player.getTeam().getStadiumName()));
        });


        return sb.toString();
    }
}
