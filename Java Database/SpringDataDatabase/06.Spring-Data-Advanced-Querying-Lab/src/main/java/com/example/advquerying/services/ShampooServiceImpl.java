package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }


    @Override
    public List<Shampoo> selectBySize(Size size) {
       return this.shampooRepository.findBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> selectBySizeOrLabel(Size size, long labelId) {
        return this.shampooRepository.findBySizeOrLabelIdOrderByPriceAsc(size, labelId);
    }

    @Override
    public List<Shampoo> selectWithPriceHigherThan(BigDecimal inputPrice) {
        return this.shampooRepository.findByPriceGreaterThanOrderByPriceDesc(inputPrice);


    }

    @Override
    public int countShampooWithLowerPrice(BigDecimal inputPrice) {
        return this.shampooRepository.countByPriceLessThan(inputPrice);
    }

    @Override
    public Set<Shampoo> selectByIngredients(Set<String> ingredients) {
        return this.shampooRepository.findByIngredientsInTheShampoo(ingredients);
    }

    @Override
    public List<Shampoo> selectWithLessIngredients(int inputNumber) {
       return this.shampooRepository.selectAllWithLessIngredientsThan(inputNumber);
    }


}
