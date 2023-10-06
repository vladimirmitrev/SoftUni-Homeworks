package com.softuni.pathfinder.service.impl;

import com.softuni.pathfinder.model.entity.CategoryEntity;
import com.softuni.pathfinder.model.entity.enums.CategoryNameEnum;
import com.softuni.pathfinder.repository.CategoryRepository;
import com.softuni.pathfinder.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryEntity findByCategoryName(CategoryNameEnum categoryNameEnum) {
        return categoryRepository
                .findByName(categoryNameEnum)
                .orElse(null);
    }
}
