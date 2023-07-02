package com.example.productsShop.service;

import com.example.productsShop.model.dto.CategoryStatsDto;
import com.example.productsShop.model.dto.ProductNameAndPriceAndSellerDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductNameAndPriceAndSellerDto> findAllProductsInRangeBetween(BigDecimal lowerRange, BigDecimal higherRange);

    List<CategoryStatsDto> getCategoryStatistics();
}
