package com.example.cardealer.model.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class CustomerNameWithBoughtCarsAndMoneySpentDto {


    @Expose
    private String fullName;
    @Expose
    private long boughtCars;

    @Expose
    private BigDecimal spentMoney;

    public CustomerNameWithBoughtCarsAndMoneySpentDto(String name, long boughtCars, BigDecimal spentMoney) {
        this.fullName = name;
        this.boughtCars = boughtCars;
        this.spentMoney = spentMoney;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(long boughtCars) {
        this.boughtCars = boughtCars;
    }

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
    }
}
