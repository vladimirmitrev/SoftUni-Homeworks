package com.example.gamestore.service;

import com.example.gamestore.model.dto.GameAddDTO;
import com.example.gamestore.model.entities.Game;
import com.example.gamestore.repository.GameRepository;
import com.example.gamestore.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {


    private final GameRepository gameRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, UserService userService, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDTO gameAddDTO) {

        Set<ConstraintViolation<GameAddDTO>> violations =
                validationUtil.getViolations(gameAddDTO);

        if(!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            return;
        }

        Game game = modelMapper.map(gameAddDTO, Game.class);


        //todo save to DB
        gameRepository.save(game);

        System.out.printf("Added %s", game.getTitle());


    }

    @Override
    public void editGame(int gameId, BigDecimal price, Double size) {
        Game game = gameRepository.findById(gameId)
                .orElse(null);

        if(game == null) {
            System.out.println("Game Id is not correct");
            return;
        }

        game.setPrice(price);
        game.setSize(size);

        gameRepository.save(game);
    }
}
