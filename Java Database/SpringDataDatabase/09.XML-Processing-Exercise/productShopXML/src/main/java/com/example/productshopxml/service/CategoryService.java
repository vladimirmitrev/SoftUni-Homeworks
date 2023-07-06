package com.example.productshopxml.service;

import com.example.productshopxml.model.dto.CategoryViewRootDto;
import com.example.productshopxml.model.entity.Category;

import java.util.Set;

public interface CategoryService {

    Set<Category> findRandomCategories();

    CategoryViewRootDto findAllCategoriesOrderByProductCount();
}
