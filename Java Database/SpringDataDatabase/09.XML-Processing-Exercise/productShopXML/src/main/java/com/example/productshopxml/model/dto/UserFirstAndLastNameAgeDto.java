package com.example.productshopxml.model.dto.seed._4dto;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserFirstAndLastNameAgeDto {


    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute(name = "age")
    private Integer age;

    @XmlElement(name = "sold-products")
    private ProductCountDto soldProducts;

    public UserFirstAndLastNameAgeDto() {
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

    public ProductCountDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductCountDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
