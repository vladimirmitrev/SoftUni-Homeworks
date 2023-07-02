package com.example.productsShop.service.Impl;

import com.example.productsShop.model.dto.CategoryStatsDto;
import com.example.productsShop.model.dto.ProductNameAndPriceAndSellerDto;
import com.example.productsShop.repository.ProductRepository;
import com.example.productsShop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductNameAndPriceAndSellerDto> findAllProductsInRangeBetween(BigDecimal lowerRange, BigDecimal higherRange) {
        return productRepository.findAllByPriceBetweenOrderByPriceAsc(lowerRange, higherRange)
                .stream()
                .map(product -> {
                    ProductNameAndPriceAndSellerDto productNameAndPriceAndSellerDto = modelMapper
                            .map(product, ProductNameAndPriceAndSellerDto.class);

                    productNameAndPriceAndSellerDto.setSeller(String.format("%s %s",
                            product.getSeller().getFirstName(),
                            product.getSeller().getLastName()));


                    return productNameAndPriceAndSellerDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryStatsDto> getCategoryStatistics() {
        return this.productRepository.getCategoryStats();

    }
}
