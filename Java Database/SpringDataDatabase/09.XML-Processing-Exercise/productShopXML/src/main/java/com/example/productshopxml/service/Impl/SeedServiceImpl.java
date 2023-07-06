package com.example.productshopxml.service.Impl;

import com.example.productshopxml.model.dto.seed.CategorySeedRootDto;
import com.example.productshopxml.model.dto.seed.ProductSeedRootDto;
import com.example.productshopxml.model.dto.seed.UserSeedRootDto;
import com.example.productshopxml.model.entity.Category;
import com.example.productshopxml.model.entity.Product;
import com.example.productshopxml.model.entity.User;
import com.example.productshopxml.repository.CategoryRepository;
import com.example.productshopxml.repository.ProductRepository;
import com.example.productshopxml.repository.UserRepository;
import com.example.productshopxml.service.CategoryService;
import com.example.productshopxml.service.ProductService;
import com.example.productshopxml.service.SeedService;
import com.example.productshopxml.service.UserService;
import com.example.productshopxml.util.ValidationUtil;
import com.example.productshopxml.util.XmlParser;
import jakarta.transaction.Transactional;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

import static com.example.productshopxml.globalConstants.GlobalConstants.*;

@Service
public class SeedServiceImpl implements SeedService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;

    private final XmlParser xmlParser;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;


    public SeedServiceImpl(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository, UserService userService, ProductService productService, CategoryService categoryService, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public void seedUsers() throws JAXBException, FileNotFoundException {

        if (userRepository.count() > 0) {
            return;
        }

        UserSeedRootDto userSeedRootDto =
                xmlParser.fromFile(RESOURCES_FILE_PATH + USERS_FILE_PATH, UserSeedRootDto.class);

        userSeedRootDto.getUsers()
                .stream()
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);

    }

    @Override
    public void seedCategories() throws JAXBException, FileNotFoundException {

        if (categoryRepository.count() > 0) {
            return;
        }

        CategorySeedRootDto categorySeedRootDto =
                xmlParser.fromFile(RESOURCES_FILE_PATH + CATEGORIES_FILE_PATH, CategorySeedRootDto.class);

        categorySeedRootDto.getCategories()
                .stream()
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    @Transactional
    public void seedProducts() throws JAXBException, FileNotFoundException {

        if (productRepository.count() > 0) {
            return;
        }

        ProductSeedRootDto productSeedRootDto =
                xmlParser.fromFile(RESOURCES_FILE_PATH + PRODUCTS_FILE_PATH, ProductSeedRootDto.class);



        productSeedRootDto.getProducts()
                .stream()
                .filter(validationUtil::isValid)
                .map(productToMap -> {
                    Product product = modelMapper.map(productToMap, Product.class);
                    product.setSeller(userService.findRandomUser());
                    if (product.getPrice().compareTo(BigDecimal.valueOf(600L)) > 0) {
                        product.setBuyer(userService.findRandomUser());
                    }
                    product.setCategories(categoryService.findRandomCategories());

                    return product;
                })
                .forEach(productRepository::save);


//        productSeedRootDto.getProducts()
//                .stream()
//                .filter(validationUtil::isValid)
//                .map(productSeedDto -> {
//                    Product product = modelMapper.map(productSeedDto, Product.class);
//                    product.setSeller(userService.findRandomUser());
//                    if (product.getPrice().compareTo(BigDecimal.valueOf(700L)) > 0) {
//                        product.setBuyer(userService.findRandomUser());
//                    }
//                    product.setCategories(categoryService.findRandomCategories());
//
//                    return product;
//                })
//                .forEach(productRepository::save);
    }
}
