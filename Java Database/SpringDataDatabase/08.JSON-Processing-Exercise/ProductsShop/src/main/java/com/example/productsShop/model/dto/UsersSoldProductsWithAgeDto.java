package com.example.productsShop.model.dto;

import com.google.gson.annotations.Expose;

public class UsersSoldProductsWithAgeDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    @Expose
    private SoldProductsCountDto soldProducts;

    public UsersSoldProductsWithAgeDto() {
        this.soldProducts = new SoldProductsCountDto();
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SoldProductsCountDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(SoldProductsCountDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
