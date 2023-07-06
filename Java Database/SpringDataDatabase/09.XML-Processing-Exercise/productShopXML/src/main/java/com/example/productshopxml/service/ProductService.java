package com.example.productshopxml.service;

import com.example.productshopxml.model.dto.ProductsInRangeRootDto;

public interface ProductService {
    ProductsInRangeRootDto findAllProductWithoutBuyer();
}
