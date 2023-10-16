package com.resellerapp.model.binding;

import com.resellerapp.model.entity.enums.ConditionNameEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class OfferAddBindingModel {


    @NotEmpty
    @Size(min = 2, max = 50)
    private String description;

    @NotNull
    @Positive
    private Double price;

    @NotNull
    private ConditionNameEnum condition;

    public OfferAddBindingModel() {
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

    public ConditionNameEnum getCondition() {
        return condition;
    }

    public void setCondition(ConditionNameEnum condition) {
        this.condition = condition;
    }
}
