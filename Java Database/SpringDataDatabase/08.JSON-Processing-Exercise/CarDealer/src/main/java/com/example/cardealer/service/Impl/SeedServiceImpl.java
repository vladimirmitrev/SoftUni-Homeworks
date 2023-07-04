package com.example.cardealer.service.Impl;

import com.example.cardealer.model.dto.importDto.CarSeedDto;
import com.example.cardealer.model.dto.importDto.CustomerSeedDto;
import com.example.cardealer.model.dto.importDto.PartSeedDto;
import com.example.cardealer.model.dto.importDto.SupplierSeedDto;
import com.example.cardealer.model.entity.*;
import com.example.cardealer.repository.*;
import com.example.cardealer.service.*;
import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Arrays;
import java.util.Set;

import static com.example.cardealer.globalConstants.GlobalConstants.*;

@Service
public class SeedServiceImpl implements SeedService {

    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final CustomerRepository customerRepository;

    private final SaleRepository saleRepository;

    private final SupplierRepository supplierRepository;
    private final SupplierService supplierService;
    private final PartService partService;

    private final CarService carService;

    private final SaleService saleService;

    private final CustomerService customerService;

    private final ModelMapper modelMapper;

    private final Gson gson;

    @Autowired
    public SeedServiceImpl(CarRepository carRepository, PartRepository partRepository, CustomerRepository customerRepository, SupplierRepository supplierRepository, SaleRepository saleRepository, SupplierService supplierService, PartService partService, CarService carService, SaleService saleService, CustomerService customerService, ModelMapper modelMapper, Gson gson) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.customerRepository = customerRepository;
        this.supplierRepository = supplierRepository;
        this.saleRepository = saleRepository;
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.saleService = saleService;
        this.customerService = customerService;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedSuppliers() throws IOException {

        if (supplierRepository.count() > 0) {
            return;
        }

        String supplierFileContent = Files
                .readString(Path.of(RESOURCES_FILE_PATH + SUPPLIERS_FILE_PATH));

        SupplierSeedDto[] supplierSeedDtos = gson
                .fromJson(supplierFileContent, SupplierSeedDto[].class);

        Arrays.stream(supplierSeedDtos)
                .map(sup -> modelMapper.map(sup, Supplier.class))
                .forEach(supplierRepository::save);
    }


    @Override
    @Transactional
    public void seedParts() throws IOException {

        if (partRepository.count() > 0) {
            return;
        }

        String partsFileContent = Files
                .readString(Path.of(RESOURCES_FILE_PATH + PARTS_FILE_PATH));

        PartSeedDto[] partSeedDtos = gson
                .fromJson(partsFileContent, PartSeedDto[].class);

        Arrays.stream(partSeedDtos)
                .map(partSeedDto -> {
                    Part part = modelMapper.map(partSeedDto, Part.class);
                    part.setSupplier(supplierService.findRandomSuppliers());

                    return part;
                })
                .forEach(partRepository::save);
    }

    @Override
    @Transactional
    public void seedCars() throws IOException {
        if (carRepository.count() > 0) {
            return;
        }

        String carsFileContent = Files
                .readString(Path.of(RESOURCES_FILE_PATH + CARS_FILE_PATH));

        CarSeedDto[] carSeedDtos = gson
                .fromJson(carsFileContent, CarSeedDto[].class);

        Arrays.stream(carSeedDtos)
                .map(carSeedDto -> {
                    Car car = modelMapper.map(carSeedDto, Car.class);
                    Set<Part> partSet = partService.getRandomParts();
                    car.setParts(partSet);

                    return car;

                }).forEach(carRepository::save);
    }


    @Override
    public void seedCustomer() throws IOException {

        if (customerRepository.count() > 0) {
            return;
        }

        String customersFileContent = Files
                .readString(Path.of(RESOURCES_FILE_PATH + CUSTOMERS_FILE_PATH));

        CustomerSeedDto[] customerSeedDtos = gson
                .fromJson(customersFileContent, CustomerSeedDto[].class);

        Arrays.stream(customerSeedDtos)
                .map(customerSeedDto -> modelMapper.map(customerSeedDto, Customer.class))
                .forEach(customerRepository::save);

    }

    @Override
    @Transactional
    public void seedSales() throws IOException {

        Sale sale1 = new Sale();
        sale1.setCar(carService.getRandomCar());
        sale1.setCustomer(customerService.getRandomCustomer());
        sale1.setDiscountPercentage(saleService.getRandomDiscount());

        Sale sale2 = new Sale();
        sale2.setCar(carService.getRandomCar());
        sale2.setCustomer(customerService.getRandomCustomer());
        sale2.setDiscountPercentage(saleService.getRandomDiscount());


        Sale sale3 = new Sale();
        sale3.setCar(carService.getRandomCar());
        sale3.setCustomer(customerService.getRandomCustomer());
        sale3.setDiscountPercentage(saleService.getRandomDiscount());

        this.saleRepository.save(sale1);
        this.saleRepository.save(sale2);
        this.saleRepository.save(sale3);

    }


}
