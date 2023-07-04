package com.example.cardealer.service;

import java.io.IOException;

public interface SeedService {

    void seedSuppliers() throws IOException;

    void seedParts() throws IOException;

    void seedCars() throws IOException;

    void seedSales() throws IOException;

    void seedCustomer() throws IOException;

    default void seedAll() throws IOException {
        seedSuppliers();
        seedParts();
        seedCars();
        seedCustomer();
        seedSales();
    }

}
