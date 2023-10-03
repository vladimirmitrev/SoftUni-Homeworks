package com.softuni.coffeeshop.service;

import com.softuni.coffeeshop.model.entity.Category;
import com.softuni.coffeeshop.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
