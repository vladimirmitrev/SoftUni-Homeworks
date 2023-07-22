package com.example.football.service.impl;

import com.example.football.models.dto.PlayerImportRootDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static String PLAYERS_FILE_PATH = "src/main/resources/files/xml/players.xml";

    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    private final PlayerRepository playerRepository;
    private final StatRepository statRepository;
    private final TownRepository townRepository;
    private final TeamRepository teamRepository;


    @Autowired
    public PlayerServiceImpl(ModelMapper modelMapper, XmlParser xmlParser,
                             ValidationUtil validationUtil, PlayerRepository playerRepository,
                             StatRepository statRepository, TownRepository townRepository,
                             TeamRepository teamRepository) {
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.playerRepository = playerRepository;
        this.statRepository = statRepository;
        this.townRepository = townRepository;
        this.teamRepository = teamRepository;
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

        PlayerImportRootDto playerImportRootDto =
                xmlParser.fromFile(PLAYERS_FILE_PATH, PlayerImportRootDto.class);

        playerImportRootDto.getPlayers()
                .stream()
                .filter(playerImportDto -> {

                    boolean isValid = validationUtil.isValid(playerImportDto);

                    Optional<Player> optionalPlayer =
                            playerRepository.findPlayerByEmail(playerImportDto.getEmail());


                    if (optionalPlayer.isPresent()) {
                        isValid = false;
                    }


                    sb.append(isValid ? String.format("Successfully imported Player %s %s - %s",
                                    playerImportDto.getFirstName(), playerImportDto.getLastName(), playerImportDto.getPosition())
                                    : "Invalid Player")
                            .append(System.lineSeparator());


                    return isValid;

                })
                .map(playerImportDto -> {

                    Player player = modelMapper.map(playerImportDto, Player.class);

                    Optional<Town> town = townRepository.findTownByName(playerImportDto.getTown().getName());
                    Optional<Team> team = teamRepository.findTeamByName(playerImportDto.getTeam().getName());
                    Optional<Stat> stat = statRepository.findById(playerImportDto.getStat().getId());

                    player.setTown(town.get());
                    player.setTeam(team.get());
                    player.setStat(stat.get());

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
                playerRepository.findPlayerByBirthDateAfterAndBirthDateBeforeOrderByStat_ShootingDescStatPassingDescStatEnduranceDescLastNameAsc(after, before);

        playerList.forEach(player ->
                sb.append(String.format("Player - %s %s%n" +
                                "   Position - %s%n" +
                                "   Team - %s%n" +
                                "   Stadium - %s%n",
                        player.getFirstName(), player.getLastName(),
                        player.getPosition(),
                        player.getTeam().getName(),
                        player.getTeam().getStadiumName())));

        return sb.toString();
    }
}
