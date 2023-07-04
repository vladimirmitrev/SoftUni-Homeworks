package com.example.cardealer.service;

import com.example.cardealer.model.dto.discountSale.SaleWithDiscountDto;

import java.util.List;

public interface SaleService {

    int getRandomDiscount();


    List<SaleWithDiscountDto> getAllSalesWithDiscount();
}
