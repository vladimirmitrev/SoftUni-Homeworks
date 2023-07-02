package com.example.productsShop;

import com.example.productsShop.globalConstants.GlobalConstants;
import com.example.productsShop.model.dto.CategoryStatsDto;
import com.example.productsShop.model.dto.ProductNameAndPriceAndSellerDto;
import com.example.productsShop.model.dto.UserSoldDto;
import com.example.productsShop.model.dto.UsersAndProductsDto;
import com.example.productsShop.model.entity.User;
import com.example.productsShop.service.CategoryService;
import com.example.productsShop.service.ProductService;
import com.example.productsShop.service.SeedService;
import com.example.productsShop.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static com.example.productsShop.globalConstants.GlobalConstants.*;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final UserService userService;
    private final SeedService seedService;
    private final ProductService productService;
    private final BufferedReader bufferedReader;
    private final Gson gson;


    public CommandLineRunnerImpl(CategoryService categoryService, UserService userService, SeedService seedService, ProductService productService, Gson gson) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.seedService = seedService;
        this.productService = productService;
        this.gson = gson;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {
//        this.seedService.seedUsers();
//        this.seedService.seedCategories();
//        this.seedService.seedProducts();

        seedService.seedAll();

        System.out.println("Enter the number of query you want to see:");

        int exerciseNumber = Integer.parseInt(bufferedReader.readLine());

        switch (exerciseNumber) {
            case 1 -> q01ProductsInPriceRange();
            case 2 -> q02SuccessfullySoldProducts();
            case 3 -> q03AllCategoriesOrderedByProductCount();
            case 4 -> q04UserAndProducts();
        }


    }

    private void q04UserAndProducts() throws IOException {
        UsersAndProductsDto usersWithSoldProductsOrderByProductCount =
                this.userService.usersAndProducts();

        String fileContent = gson.toJson(usersWithSoldProductsOrderByProductCount);

//        System.out.println(fileContent);

        writeToFile(OUTPUT_PATH + USERS_AND_PRODUCTS_FILE_NAME, fileContent);

    }

    private void q03AllCategoriesOrderedByProductCount() throws IOException {
        List<CategoryStatsDto> categoryStatistics = this.productService.getCategoryStatistics();

        String fileContent =  this.gson.toJson(categoryStatistics);

//        System.out.println(fileContent);

        writeToFile(OUTPUT_PATH + CATEGORIES_BY_PRODUCTS_FILE_NAME, fileContent);


    }

    private void q02SuccessfullySoldProducts() throws IOException {
            List<UserSoldDto> userSoldDtos = userService
                    .findAllUsersWithMoreThanOneSoldProducts();

            String fileContent = gson.toJson(userSoldDtos);

//        System.out.println(fileContent);

            writeToFile(OUTPUT_PATH + USERS_SOLD_PRODUCTS_FILE_NAME, fileContent);
    }

    private void q01ProductsInPriceRange() throws IOException {
        BigDecimal lowerRange = BigDecimal.valueOf(500);
        BigDecimal upperRange = BigDecimal.valueOf(1000);

        List<ProductNameAndPriceAndSellerDto> productDtos = productService
                .findAllProductsInRangeBetween(lowerRange, upperRange);

        String fileContent = gson.toJson(productDtos);

//        System.out.println(fileContent);

        writeToFile(OUTPUT_PATH + PRODUCTS_IN_RANGE_FILE_NAME, fileContent);
    }

    private void writeToFile(String filePath, String content) throws IOException {

        Files
                .write(Path.of(filePath), Collections.singleton(content));
    }
}
