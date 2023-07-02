package com.example.productsShop.model.dto;

import com.google.gson.annotations.Expose;

public class CategorySeedDto {
    @Expose
    private String name;

    public CategorySeedDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
