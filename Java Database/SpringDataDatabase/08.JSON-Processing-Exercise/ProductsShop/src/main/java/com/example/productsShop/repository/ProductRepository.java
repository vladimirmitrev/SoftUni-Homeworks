package com.example.productsShop.repository;

import com.example.productsShop.model.dto.CategoryStatsDto;
import com.example.productsShop.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product>findAllByPriceBetweenOrderByPriceAsc(BigDecimal lowerRange, BigDecimal higherRange);

    @Query("SELECT new com.example.productsShop.model.dto.CategoryStatsDto(" +
            "c.name, COUNT(p), AVG(p.price), SUM(p.price))" +
            " FROM Product p" +
            " JOIN p.categories c" +
            " GROUP BY c" +
            " ORDER BY COUNT(p) DESC")
      List<CategoryStatsDto>getCategoryStats();
}
