package com.example.productsShop.service;

import com.example.productsShop.model.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    Set<Category> findRandomCategories();

}
