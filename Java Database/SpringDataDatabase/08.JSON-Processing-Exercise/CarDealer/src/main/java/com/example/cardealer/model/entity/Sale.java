package com.example.cardealer.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {

    @Column(name = "discount")
    private float discountPercentage;

    @OneToOne
    private Car car;
    @ManyToOne
    private Customer customer;

    public Sale() {
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
