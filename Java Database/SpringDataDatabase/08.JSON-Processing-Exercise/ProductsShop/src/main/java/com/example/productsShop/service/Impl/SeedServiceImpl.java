package com.example.productsShop.service.Impl;

import com.example.productsShop.model.dto.CategorySeedDto;
import com.example.productsShop.model.dto.ProductSeedDto;
import com.example.productsShop.model.dto.UserSeedDto;
import com.example.productsShop.model.entity.Category;
import com.example.productsShop.model.entity.Product;
import com.example.productsShop.model.entity.User;
import com.example.productsShop.repository.CategoryRepository;
import com.example.productsShop.repository.ProductRepository;
import com.example.productsShop.repository.UserRepository;
import com.example.productsShop.service.CategoryService;
import com.example.productsShop.service.SeedService;
import com.example.productsShop.service.UserService;
import com.example.productsShop.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static com.example.productsShop.globalConstants.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class SeedServiceImpl implements SeedService {

    private final static String USERS_FILE_PATH = "users.json";
    private final static String PRODUCTS_FILE_PATH = "products.json";
    private final static String CATEGORIES_FILE_PATH = "categories.json";

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;


    public SeedServiceImpl(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    @Override
    public void seedUsers() throws IOException {

        if (userRepository.count() > 0) {
            return;
        }

        String usersFileContent = Files
                .readString(Path.of(RESOURCES_FILE_PATH + USERS_FILE_PATH));

        UserSeedDto[] userSeedDtos = gson
                .fromJson(usersFileContent, UserSeedDto[].class);

        Arrays.stream(userSeedDtos)
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);

    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0) {
            return;
        }

        String categoriesFileContent = Files
                .readString(Path.of(RESOURCES_FILE_PATH + CATEGORIES_FILE_PATH));

        CategorySeedDto[] categorySeedDtos = gson
                .fromJson(categoriesFileContent, CategorySeedDto[].class);

        Arrays.stream(categorySeedDtos)
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);

    }

    @Override
    public void seedProducts() throws IOException {
        if (productRepository.count() > 0) {
            return;
        }

        String productsFileContent = Files
                .readString(Path.of(RESOURCES_FILE_PATH + PRODUCTS_FILE_PATH));

        ProductSeedDto[] productSeedDtos = gson
                .fromJson(productsFileContent, ProductSeedDto[].class);

        Arrays.stream(productSeedDtos)
                .filter(validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = modelMapper.map(productSeedDto, Product.class);
                    product.setSeller(userService.findRandomUser());
                    if (product.getPrice().compareTo(BigDecimal.valueOf(900L)) > 0) {
                        product.setBuyer(userService.findRandomUser());
                    }
                    product.setCategories(categoryService.findRandomCategories());

                    return product;
                })
                .forEach(productRepository::save);

    }
}
