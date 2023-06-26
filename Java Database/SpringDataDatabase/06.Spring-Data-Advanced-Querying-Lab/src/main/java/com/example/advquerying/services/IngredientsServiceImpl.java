package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    private final IngredientsRepository ingredientsRepository;


    @Autowired
    public IngredientsServiceImpl(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }


    @Override
    public List<Ingredient> selectStartsWith(String startLetter) {
        return this.ingredientsRepository.findByNameStartingWith(startLetter);
    }

    @Override
    public List<Ingredient> selectWithGivenList(List<String> inputStrings) {
        return this.ingredientsRepository.findByNameInOrderByPriceAsc(inputStrings);
    }

    @Override
    @Transactional
    public void deleteByName(String inputName) {
       this.ingredientsRepository.deleteByName(inputName);
    }

    @Override
    @Transactional
    public void updateAllIngredientsPriceByPercent(double percent) {

        BigDecimal percentDecimal = BigDecimal.valueOf(percent);

        this.ingredientsRepository.updateAllIngredientsPriceByPercent(percentDecimal);
    }

    @Override
    @Transactional
    public void updateAllPriceByNames(Set<String> ingredients) {
        this.ingredientsRepository.updateIngredientsPriceByName(ingredients);
    }


}
