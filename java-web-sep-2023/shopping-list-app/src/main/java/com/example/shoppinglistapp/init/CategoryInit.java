package com.example.shoppinglistapp.init;

import com.example.shoppinglistapp.model.entity.Category;
import com.example.shoppinglistapp.model.entity.enums.CategoryNameEnum;
import com.example.shoppinglistapp.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CategoryInit implements CommandLineRunner {


    private final CategoryRepository categoryRepository;

    public CategoryInit(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category();
                    category.setName(categoryNameEnum);

                    categoryRepository.save(category);
                });
    }
}
