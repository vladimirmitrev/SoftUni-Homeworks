package com.example.cardealer.service;

import com.example.cardealer.model.dto.CustomerNameWithBoughtCarsAndMoneySpentDto;
import com.example.cardealer.model.dto.CustomerWithIdDto;
import com.example.cardealer.model.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer getRandomCustomer();

    List<CustomerWithIdDto> findAllCustomersOrderByBirthday();

    List<CustomerNameWithBoughtCarsAndMoneySpentDto> getCustomerWithBoughtCars();
}
