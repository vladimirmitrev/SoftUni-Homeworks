package com.example.productshopxml.service;

import jakarta.xml.bind.JAXBException;

import java.io.FileNotFoundException;

public interface SeedService {


    void seedUsers() throws JAXBException, FileNotFoundException;
    void seedCategories() throws JAXBException, FileNotFoundException;
    void seedProducts() throws JAXBException, FileNotFoundException;

}
