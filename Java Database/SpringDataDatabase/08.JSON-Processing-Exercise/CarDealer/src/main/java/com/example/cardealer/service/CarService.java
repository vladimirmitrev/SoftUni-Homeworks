package com.example.cardealer.service;

import com.example.cardealer.model.dto.CarWithIdDto;
import com.example.cardealer.model.dto.discountSale.CarWithPartListDto;
import com.example.cardealer.model.entity.Car;

import java.util.List;

public interface CarService {

    Car getRandomCar();

    List<CarWithIdDto> getAllCarsFrom(String make);

    List<CarWithPartListDto> getAllCarWithTheirPartsList();
}
