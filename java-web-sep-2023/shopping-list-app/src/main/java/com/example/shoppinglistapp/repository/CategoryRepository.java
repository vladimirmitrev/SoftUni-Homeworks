package com.example.shoppinglistapp.repository;

import com.example.shoppinglistapp.model.entity.Category;
import com.example.shoppinglistapp.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryNameEnum category);
}
