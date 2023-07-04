package com.example.cardealer.model.dto.discountSale;

import com.example.cardealer.model.dto.CustomerWithIdDto;
import com.example.cardealer.model.dto.discountSale.CarDto;
import com.example.cardealer.model.dto.discountSale.CarWithoutPartsDto;
import com.example.cardealer.model.dto.discountSale.SaleWithDiscountDto;

import java.math.BigDecimal;

public class SaleDto {
    private float discount;
    private CarDto car;
    private CustomerWithIdDto customer;

    public SaleDto() {
    }

    public SaleDto(float discount, CarDto car, CustomerWithIdDto customer) {
        this.discount = discount;
        this.car = car;
        this.customer = customer;
    }

    public SaleWithDiscountDto saleWithDiscountDto(){
        CarWithoutPartsDto car = new CarWithoutPartsDto(getCar().getMake(), getCar().getModel(), getCar().getTravelledDistance());

        BigDecimal price = this.car.getCarPrice();

        BigDecimal priceAfterDiscount = price.subtract(price.multiply(BigDecimal.valueOf(discount/100.0)));

        return new SaleWithDiscountDto(car, customer.getName(), discount/100.0,  price, priceAfterDiscount);
    }

//    public SaleWithDiscountDto saleWithDiscountDto(){
//        CarWithPartsDto car = new CarWithPartsDto(getCar().getMake(), getCar().getModel(), getCar().getTravelledDistance());
//
//        BigDecimal price = this.car.getCarPrice();
//
//        BigDecimal priceAfterDiscount = price.subtract(price.multiply(BigDecimal.valueOf(discount/100.0)));
//
//        return new SaleWithDiscountDto(car, customer.getName(), discount/100.0, price, priceAfterDiscount);
//    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }

    public CustomerWithIdDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerWithIdDto customer) {
        this.customer = customer;
    }
}