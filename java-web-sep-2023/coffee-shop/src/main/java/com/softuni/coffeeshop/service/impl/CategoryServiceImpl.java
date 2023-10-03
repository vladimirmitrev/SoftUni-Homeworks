package com.softuni.coffeeshop.service.impl;

import com.softuni.coffeeshop.model.entity.Category;
import com.softuni.coffeeshop.model.entity.enums.CategoryNameEnum;
import com.softuni.coffeeshop.repository.CategoryRepository;
import com.softuni.coffeeshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if(categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category();
                    category.setName(categoryNameEnum);
                    switch (categoryNameEnum) {
                        case DRINK -> category.setNeededTime(1);
                        case COFFEE ->  category.setNeededTime(2);
                        case OTHER -> category.setNeededTime(5);
                        case CAKE -> category.setNeededTime(10);
                    }

                    categoryRepository.save(category);
                });
    }
}
