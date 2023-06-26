package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;

import java.util.List;
import java.util.Set;

public interface IngredientsService {
    List<Ingredient> selectStartsWith(String startLetter);

    List<Ingredient> selectWithGivenList(List<String> inputStrings);

    void deleteByName(String inputName);


    void updateAllIngredientsPriceByPercent(double percent);

    void updateAllPriceByNames(Set<String> ingredients);
}
