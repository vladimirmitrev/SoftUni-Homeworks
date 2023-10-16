package com.resellerapp.model.entity;

import com.resellerapp.model.entity.enums.ConditionNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "conditions")
public class ConditionEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private ConditionNameEnum name;

    @Column(nullable = false)
    private String description;

    public ConditionEntity() {
    }

    public ConditionNameEnum getName() {
        return name;
    }

    public void setName(ConditionNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
