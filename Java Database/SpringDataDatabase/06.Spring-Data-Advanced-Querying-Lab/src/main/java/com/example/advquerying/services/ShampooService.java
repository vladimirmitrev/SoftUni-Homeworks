package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ShampooService {
    List<Shampoo> selectBySize(Size size);

    List<Shampoo> selectBySizeOrLabel(Size size, long labelId);

    List<Shampoo> selectWithPriceHigherThan(BigDecimal inputPrice);


    int countShampooWithLowerPrice(BigDecimal inputPrice);

    Set<Shampoo> selectByIngredients(Set<String> ingredients);

    List<Shampoo> selectWithLessIngredients(int inputNumber);
}
