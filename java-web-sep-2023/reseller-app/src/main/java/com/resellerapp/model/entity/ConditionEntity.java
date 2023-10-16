package com.resellerapp.model.entity;

import com.resellerapp.model.entity.enums.ConditionNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "conditions")
public class ConditionEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private ConditionNameEnum conditionNameEnum;

    @Column(nullable = false)
    private String description;

    public ConditionEntity() {
    }

    public ConditionNameEnum getConditionNameEnum() {
        return conditionNameEnum;
    }

    public void setConditionNameEnum(ConditionNameEnum conditionNameEnum) {
        this.conditionNameEnum = conditionNameEnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
