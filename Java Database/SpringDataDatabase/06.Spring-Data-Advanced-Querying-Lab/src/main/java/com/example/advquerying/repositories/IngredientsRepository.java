package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByNameStartingWith(String startLetter);

    List<Ingredient> findByNameInOrderByPriceAsc(List<String> inputStrings);

    void deleteByName(String inputName);

    @Modifying
    @Query("UPDATE Ingredient i SET i.price = i.price + (i.price * :multiplier)")
    void updateAllIngredientsPriceByPercent(@Param("multiplier") BigDecimal percent);

    @Modifying
    @Query("UPDATE Ingredient i " +
            "SET i.price = i.price * 1.10 " +
            "WHERE i.name IN :givenList")
    void updateIngredientsPriceByName(Set<String> givenList);
}
