package com.resellerapp.model.view;

import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.model.entity.enums.ConditionNameEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OfferViewModel {

    private Long id;
    private String description;
    private Double price;
    private ConditionNameEnum conditionNameEnum;

    public OfferViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ConditionNameEnum getConditionNameEnum() {
        return conditionNameEnum;
    }

    public void setConditionNameEnum(ConditionNameEnum conditionNameEnum) {
        this.conditionNameEnum = conditionNameEnum;
    }
}
