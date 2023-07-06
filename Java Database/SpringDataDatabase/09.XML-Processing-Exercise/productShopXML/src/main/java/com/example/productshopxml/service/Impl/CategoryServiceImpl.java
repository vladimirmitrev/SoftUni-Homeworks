package com.example.productshopxml.service.Impl;

import com.example.productshopxml.model.dto.CategoryViewRootDto;
import com.example.productshopxml.model.dto.CategoryWithInfoDto;
import com.example.productshopxml.model.entity.Category;
import com.example.productshopxml.repository.CategoryRepository;
import com.example.productshopxml.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<Category> findRandomCategories() {
        Set<Category> categorySet = new HashSet<>();
        int categoryCount = ThreadLocalRandom
                .current().nextInt(1, 3);

        long totalCategoriesCount = categoryRepository.count();

        for (int i = 0; i < categoryCount; i++) {
            long randomId = ThreadLocalRandom
                    .current().nextLong(1, totalCategoriesCount + 1);

            categorySet.add(categoryRepository.findById(randomId).orElse(null));
        }

        return categorySet;
    }

    @Override
    public CategoryViewRootDto findAllCategoriesOrderByProductCount() {

        CategoryViewRootDto categoryViewRootDto = new CategoryViewRootDto();

        categoryViewRootDto.setCategories(categoryRepository.getAllCategoriesOrderByProductCount()
                .stream()
                .map(category -> modelMapper.map(category, CategoryWithInfoDto.class))
                .collect(Collectors.toList())
        );

        return categoryViewRootDto;
    }
}
