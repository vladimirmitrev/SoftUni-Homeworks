package com.example.productshopxml;

import com.example.productshopxml.model.dto.CategoryViewRootDto;
import com.example.productshopxml.model.dto.ProductsInRangeRootDto;
import com.example.productshopxml.model.dto.UserWithProductsRootDto;
import com.example.productshopxml.model.dto.seed._4dto.UserViewRootDto;
import com.example.productshopxml.service.CategoryService;
import com.example.productshopxml.service.ProductService;
import com.example.productshopxml.service.SeedService;
import com.example.productshopxml.service.UserService;
import com.example.productshopxml.util.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.example.productshopxml.globalConstants.GlobalConstants.*;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final SeedService seedService;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;

    private final BufferedReader bufferedReader;
    private final XmlParser xmlParser;


    @Autowired
    public CommandLineRunnerImpl(SeedService seedService, CategoryService categoryService, UserService userService, ProductService productService, XmlParser xmlParser) {
        this.seedService = seedService;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.xmlParser = xmlParser;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {

        this.seedService.seedUsers();
        this.seedService.seedCategories();
        this.seedService.seedProducts();
        System.out.println("Enter the number of query you want to run:");

        int exerciseNumber = Integer.parseInt(bufferedReader.readLine());


        switch (exerciseNumber) {
            case 1 -> q01ProductsInPriceRange();
            case 2 -> q02UsersWithSoldProducts();
            case 3 -> q03AllCategoriesOrderedByProductCount();
            case 4 -> q04UserAndProducts();
        }
    }

    private void q04UserAndProducts() throws JAXBException {

        UserViewRootDto rootDto = this.userService.findAllUsersAndProducts();

        xmlParser.writeToFile(OUTPUT_PATH + USERS_AND_PRODUCTS_FILE_NAME, rootDto);
    }

    private void q03AllCategoriesOrderedByProductCount() throws JAXBException {

        CategoryViewRootDto rootDto =
                this.categoryService.findAllCategoriesOrderByProductCount();

        xmlParser.writeToFile(OUTPUT_PATH + CATEGORIES_BY_PRODUCTS_FILE_NAME, rootDto);

    }

    private void q02UsersWithSoldProducts() throws JAXBException {
        UserWithProductsRootDto rootDto =
                this.userService.findAllUserWithSoldProducts();

        xmlParser.writeToFile(OUTPUT_PATH + USERS_SOLD_PRODUCTS_FILE_NAME, rootDto);
    }

    private void q01ProductsInPriceRange() throws JAXBException {

        ProductsInRangeRootDto rootDto =
                this.productService.findAllProductWithoutBuyer();

        xmlParser.writeToFile(OUTPUT_PATH + PRODUCTS_IN_RANGE_FILE_NAME, rootDto);
    }
}
