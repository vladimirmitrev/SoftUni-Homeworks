package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findBySizeOrderById(Size size);

    List<Shampoo> findBySizeOrLabelIdOrderByPriceAsc(Size size, Long labelId);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal inputPrice);


    int countByPriceLessThan(BigDecimal inputPrice);

    @Query("SELECT DISTINCT s FROM Shampoo s " +
            "JOIN s.ingredients AS i " +
            "WHERE i.name IN :ingredientsNames")
    Set<Shampoo> findByIngredientsInTheShampoo(
            @Param("ingredientsNames") Set<String> ingredients);

    @Query("SELECT s FROM Shampoo s " +
            "WHERE s.ingredients.size < 2")
    List<Shampoo> selectAllWithLessIngredientsThan(int inputNumber);
}
