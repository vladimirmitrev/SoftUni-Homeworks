package com.softuni.coffeeshop.repository;

import com.softuni.coffeeshop.model.entity.Category;
import com.softuni.coffeeshop.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


   Optional<Category> findByName(CategoryNameEnum name);
}
