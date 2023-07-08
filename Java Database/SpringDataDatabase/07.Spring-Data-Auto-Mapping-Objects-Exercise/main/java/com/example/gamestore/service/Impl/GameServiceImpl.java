package com.example.gamestore.service.Impl;

import com.example.gamestore.model.dto.GameAddDTO;
import com.example.gamestore.model.dto.OwnedGamesDto;
import com.example.gamestore.model.entities.Game;
import com.example.gamestore.model.entities.User;
import com.example.gamestore.repository.GameRepository;
import com.example.gamestore.repository.UserRepository;
import com.example.gamestore.service.GameService;
import com.example.gamestore.service.UserService;
import com.example.gamestore.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {


    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private User loggedInUser;


    public GameServiceImpl(GameRepository gameRepository, UserRepository userRepository, UserService userService, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;

    }

    @Override
    public void addGame(GameAddDTO gameAddDTO) {


//        if(loggedInUser == null) {
//            System.out.println("Please first login!");
//            return;
//        }

//        if(!loggedInUser.getAdmin() || loggedInUser.getAdmin() == null) {
//            System.out.println("Only admins can add,edit or delete games!");
//            return;
//        }


        Set<ConstraintViolation<GameAddDTO>> violations =
                validationUtil.getViolations(gameAddDTO);

        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            return;
        }

        Game game = modelMapper.map(gameAddDTO, Game.class);


        //todo save to DB
        gameRepository.save(game);

        System.out.printf("Added %s%n", game.getTitle());


    }

    @Override
    public void editGame(int gameId, BigDecimal price, Double size) {
        Game game = gameRepository.findById(gameId)
                .orElse(null);

        if (game == null) {
            System.out.println("Game Id is not correct");
            return;
        }

        game.setPrice(price);
        game.setSize(size);

        gameRepository.save(game);
    }

    @Override
    public void deleteGame(int gameId) {
        Game game = gameRepository.findById(gameId)
                .orElse(null);

        if (game == null) {
            System.out.println("Game Id is not correct");
            return;
        }

        System.out.printf("Deleted %s%n", game.getTitle());
        gameRepository.delete(game);
    }

    @Override
    public void printAllGames() {
        List<Game> gamesList = gameRepository.findAll();

        gamesList.forEach(game -> System.out.printf("%s %.2f%n", game.getTitle(), game.getPrice()));
    }

    @Override
    public void detailsForGame(String currentGame) {

        List<Game> gameByTitle = gameRepository.findGameByTitle(currentGame);

        gameByTitle.forEach(game -> System.out.printf("Title: %s%n" +
                        "Price: %.2f%n" +
                        "Description: %s%n" +
                        "Release date: %s%n", game.getTitle(),
                game.getPrice(),
                game.getDescription(), game.getReleaseDate()));

    }

    @Override
    public void ownedGames() {
        List<Game> gameList = gameRepository.findAll();

        gameList.forEach(game -> System.out.printf("%s%n", game.getTitle()));

    }

}
