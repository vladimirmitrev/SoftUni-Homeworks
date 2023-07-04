package com.example.cardealer.service.Impl;

import com.example.cardealer.model.dto.discountSale.SaleDto;
import com.example.cardealer.model.dto.discountSale.SaleWithDiscountDto;
import com.example.cardealer.repository.SaleRepository;
import com.example.cardealer.service.SaleService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.stream;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;

    public SaleServiceImpl(SaleRepository saleRepository, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public int getRandomDiscount() {

        List<Integer> list = List.of(0, 5, 10, 15, 20, 30, 40, 50);

        Random random = new Random();

        int randomPercentage = list.get(random.nextInt(list.size()));

        return randomPercentage;
    }

    @Override
    @Transactional
    public List<SaleWithDiscountDto> getAllSalesWithDiscount() {
        return this.saleRepository
                .findAll()
                .stream()
                .map(sale -> modelMapper.map(sale, SaleDto.class))
                .map(SaleDto::saleWithDiscountDto)
                .toList();
    }

}
