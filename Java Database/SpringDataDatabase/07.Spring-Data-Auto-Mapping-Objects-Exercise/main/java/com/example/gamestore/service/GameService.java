package com.example.gamestore.service;

import com.example.gamestore.model.dto.GameAddDTO;

import java.math.BigDecimal;

public interface GameService {
    void addGame(GameAddDTO gameAddDTO);

    void editGame(int gameId, BigDecimal price, Double size);

    void deleteGame(int gameId);

    void printAllGames();

    void detailsForGame(String currentGame);

    void ownedGames();
}
