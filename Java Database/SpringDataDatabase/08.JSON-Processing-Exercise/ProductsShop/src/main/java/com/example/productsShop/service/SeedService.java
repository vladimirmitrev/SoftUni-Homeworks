package com.example.productsShop.service;

import java.io.IOException;

public interface SeedService {

    void seedUsers() throws IOException;
    void seedProducts() throws IOException;
    void seedCategories() throws IOException;

    default void seedAll() throws IOException {
        seedUsers();
        seedProducts();
        seedCategories();
    }
}
