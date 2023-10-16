package com.resellerapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Double price;
    @ManyToOne
    private ConditionEntity condition;

    public OfferEntity() {
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

    public ConditionEntity getCondition() {
        return condition;
    }

    public void setCondition(ConditionEntity condition) {
        this.condition = condition;
    }

    //•	Has an Id – “UUID-String” or Long
    //•	Has a Description (not null)
    //o	Description length must be between 2 and 50 characters (inclusive of 2 and 50).
    //•	Has a Price (not null) - floating point number
    //o	The price must be a positive number
    //•	Has a Condition (not null)
    //o	One offer has one contition and one condition can have many offers.
}
