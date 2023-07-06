package com.example.productshopxml.service.Impl;

import com.example.productshopxml.model.dto.ProductWithSellerDto;
import com.example.productshopxml.model.dto.ProductsInRangeRootDto;
import com.example.productshopxml.repository.ProductRepository;
import com.example.productshopxml.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    public ProductsInRangeRootDto findAllProductWithoutBuyer() {

        BigDecimal lowerBound = BigDecimal.valueOf(500L);
        BigDecimal upperBound = BigDecimal.valueOf(1000L);

        ProductsInRangeRootDto rootDto = new ProductsInRangeRootDto();

        rootDto
                .setProducts(productRepository
                        .findAllByPriceBetweenAndBuyerIsNullOrderByPrice(lowerBound, upperBound)
                        .stream()
                        .map(product -> {
                            ProductWithSellerDto productsWithSellerDto =
                                    modelMapper.map(product, ProductWithSellerDto.class);
                            productsWithSellerDto.setSeller(String.format("%s %s",
                                    product.getSeller().getFirstName(),
                                    product.getSeller().getLastName()));

                            return productsWithSellerDto;
                        })
                        .collect(Collectors.toList()));

        return rootDto;
    }
    }



