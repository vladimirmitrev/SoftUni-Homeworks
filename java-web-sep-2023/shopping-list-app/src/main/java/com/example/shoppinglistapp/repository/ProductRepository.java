package com.example.shoppinglistapp.repository;

import com.example.shoppinglistapp.model.dto.ProductViewBindingModel;
import com.example.shoppinglistapp.model.entity.Product;
import com.example.shoppinglistapp.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByCategoryName(CategoryNameEnum food);
}
