package com.softuni.pathfinder.model.entity;

import com.softuni.pathfinder.model.entity.enums.CategoryNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")

public class CategoryEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryNameEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public CategoryEntity() {
    }

    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
