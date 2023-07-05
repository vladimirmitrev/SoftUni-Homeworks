package com.example.productshopxml.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column
    private Integer age;

    @ManyToMany
    private Set<User> friends;
    @OneToMany(targetEntity = Product.class, mappedBy = "buyer")
    private Set<Product> soldProducts;

    @OneToMany(targetEntity = Product.class, mappedBy = "seller")
    private Set<Product> sellingItems;


    public User() {
    }

    public Set<Product> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<Product> soldProducts) {
        this.soldProducts = soldProducts;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public Set<Product> getSellingItems() {
        return sellingItems;
    }

    public void setSellingItems(Set<Product> sellingItems) {
        this.sellingItems = sellingItems;
    }
}
