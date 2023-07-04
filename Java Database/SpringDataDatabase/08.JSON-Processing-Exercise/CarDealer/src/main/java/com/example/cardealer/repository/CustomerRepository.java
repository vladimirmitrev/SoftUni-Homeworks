package com.example.cardealer.repository;

import com.example.cardealer.model.dto.CustomerNameWithBoughtCarsAndMoneySpentDto;
import com.example.cardealer.model.dto.CustomerWithIdDto;
import com.example.cardealer.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    @Query("SELECT c FROM Customer c" +
            " ORDER BY c.birthDate, c.isYoungDriver")
     List<Customer> findAllOrderByBirthDateAscYoungDriverAsc();

    @Query("SELECT new com.example.cardealer.model.dto.CustomerNameWithBoughtCarsAndMoneySpentDto (" +
            "c.name, COUNT(s), SUM(p.price))" +
            " FROM Customer c" +
            " JOIN c.sales s" +
            " JOIN s.car car" +
            " JOIN car.parts p" +
            " where size(c.sales) > 0" +
            " GROUP BY c" +
            " ORDER BY count(s) desc, sum(p.price) desc")

    List<CustomerNameWithBoughtCarsAndMoneySpentDto>getCustomerWithBoughtCars();
 }
