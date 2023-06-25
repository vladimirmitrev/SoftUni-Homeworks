package com.example.bookshopsystem.services;

import com.example.bookshopsystem.entities.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategories();
}
