package com.example.gamestore;

import com.example.gamestore.model.dto.GameAddDTO;
import com.example.gamestore.model.dto.UserLoginDto;
import com.example.gamestore.model.dto.UserRegisterDto;
import com.example.gamestore.service.GameService;
import com.example.gamestore.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final BufferedReader bufferedReader;
    private final UserService userService;
    private final GameService gameService;

    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {


        while (true) {

            System.out.println("Enter your commands:");

            String[] commands = bufferedReader.readLine().split("\\|");

            switch (commands[0]) {
                case "RegisterUser" -> userService
                        .registerUser(
                                new UserRegisterDto(commands[1], commands[2],
                                        commands[3], commands[4]));

                case "LoginUser" -> userService
                        .loginUser(new UserLoginDto(commands[1], commands[2]));

                case "Logout" -> userService
                        .logout();

                case "AddGame" -> gameService
                        .addGame(new GameAddDTO(commands[1], new BigDecimal(commands[2]),
                                Double.parseDouble(commands[3]), commands[4],
                                commands[5], commands[6],
                                LocalDate.parse(commands[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"))));


                case "EditGame" -> gameService
                        .editGame(Integer.parseInt(commands[1]),
                                new BigDecimal(commands[2].split("=")[1]),
                                Double.parseDouble(commands[3].split("=")[1]));

                case "DeleteGame" -> gameService
                        .deleteGame(Integer.parseInt(commands[1]));

                case "AllGames" -> gameService.printAllGames();

                case "DetailGame" -> gameService.detailsForGame(commands[1]);

                case "OwnedGames" -> gameService.ownedGames();
            }

        }
    }
}
