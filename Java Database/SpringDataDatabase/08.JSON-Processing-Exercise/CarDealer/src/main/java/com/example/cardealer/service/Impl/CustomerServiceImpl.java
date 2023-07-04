package com.example.cardealer.service.Impl;

import com.example.cardealer.model.dto.CustomerNameWithBoughtCarsAndMoneySpentDto;
import com.example.cardealer.model.dto.CustomerWithIdDto;
import com.example.cardealer.model.entity.Customer;
import com.example.cardealer.repository.CustomerRepository;
import com.example.cardealer.service.CustomerService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Customer getRandomCustomer() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, customerRepository.count() + 1);

        return customerRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    @Transactional
    public List<CustomerWithIdDto> findAllCustomersOrderByBirthday() {

        return customerRepository.findAllOrderByBirthDateAscYoungDriverAsc()
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerWithIdDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<CustomerNameWithBoughtCarsAndMoneySpentDto> getCustomerWithBoughtCars() {
        return this.customerRepository.getCustomerWithBoughtCars();
    }
}
