package softuni.exam.service;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.PlayerImportDto;
import softuni.exam.domain.entities.Player;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final String PLAYERS_FILE_PATH = "src/main/resources/files/json/players.json";
    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    private final Gson gson;

    private final TeamService teamService;
    private final PictureService pictureService;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository,
                             ModelMapper modelMapper, ValidationUtil validationUtil,
                             Gson gson, TeamService teamService, PictureService pictureService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.teamService = teamService;
        this.pictureService = pictureService;
    }

    @Override
    public String importPlayers() throws IOException {
        StringBuilder sb = new StringBuilder();

        PlayerImportDto[] playerImportDtos =
                gson.fromJson(readPlayersJsonFile(), PlayerImportDto[].class);

        Arrays.stream(playerImportDtos)
                .filter(playerImportDto -> {

                    boolean isValid = validationUtil.isValid(playerImportDto);


                    sb.append(isValid ? String.format("Successfully imported player: %s %s",
                                    playerImportDto.getFirstName(), playerImportDto.getLastName())
                                    : "Invalid player")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(playerImportDto -> {
                    Player player = modelMapper.map(playerImportDto, Player.class);

                    player.setPicture(pictureService.findPictureByUrl(playerImportDto.getPicture().getUrl()));
                    player.setTeam(teamService.findTeamByName(playerImportDto.getTeam().getName()));

                    return player;
                })
                .forEach(playerRepository::save);


        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return Files.readString(Path.of(PLAYERS_FILE_PATH));
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        StringBuilder sb = new StringBuilder();

        BigDecimal greaterSalary = BigDecimal.valueOf(100000);

        List<Player> playerList =
                playerRepository.findPlayerBySalaryGreaterThanOrderBySalaryDesc(greaterSalary);

        playerList.forEach(player ->
                sb.append(String.format("Player name: %s %s%n" +
                                "   Number: %d%n" +
                                "   Salary: %.2f%n" +
                                "   Team: %s%n",
                        player.getFirstName(),
                        player.getLastName(),
                        player.getNumber(),
                        player.getSalary(),
                        player.getTeam().getName())));
        return sb.toString();
    }

    @Override
    public String exportPlayersInATeam() {
        StringBuilder sb = new StringBuilder();

        String teamName = "North Hub";

        List<Player> playerList =
                playerRepository.findPlayerByTeamNameOrderById(teamName);

        playerList.forEach(player ->
                sb.append(String.format("Team: %s%n" +
                                "   Player name: %s %s - %s%n" +
                                "   Number: %d%n",
                        player.getTeam().getName(),
                        player.getFirstName(), player.getLastName(),
                        player.getPosition(),
                        player.getNumber())));


        return sb.toString();
    }
}
