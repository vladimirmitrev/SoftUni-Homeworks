package com.softuni.pathfinder.service;

import com.softuni.pathfinder.model.entity.CategoryEntity;
import com.softuni.pathfinder.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    CategoryEntity findByCategoryName(CategoryNameEnum categoryNameEnum);
}
