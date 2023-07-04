package com.example.cardealer.service.Impl;

import com.example.cardealer.model.dto.CarWithIdDto;
import com.example.cardealer.model.dto.discountSale.CarWithPartListDto;
import com.example.cardealer.model.entity.Car;
import com.example.cardealer.repository.CarRepository;
import com.example.cardealer.service.CarService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {


    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Car getRandomCar() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, carRepository.count() + 1);

        return carRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public List<CarWithIdDto> getAllCarsFrom(String make) {

        return carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc(make)
                .stream()
                .map(car -> modelMapper.map(car, CarWithIdDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<CarWithPartListDto> getAllCarWithTheirPartsList() {

        return this.carRepository.findAll()
                .stream()
                .map(car -> modelMapper.map(car, CarWithPartListDto.class))
                .collect(Collectors.toList());
    }
}
