package com.resellerapp.model.view;

import com.resellerapp.model.entity.enums.ConditionNameEnum;

import java.util.Set;

public class OfferViewOthersModel {

    private Long id;
    private String username;
    private String description;
    private ConditionNameEnum conditionNameEnum;
    private Double price;

    public OfferViewOthersModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ConditionNameEnum getConditionNameEnum() {
        return conditionNameEnum;
    }

    public void setConditionNameEnum(ConditionNameEnum conditionNameEnum) {
        this.conditionNameEnum = conditionNameEnum;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //    private Set<User> userLikes;
}
