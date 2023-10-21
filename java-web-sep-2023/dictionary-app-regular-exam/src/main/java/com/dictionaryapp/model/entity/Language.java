package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.entity.enums.LanguageNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private LanguageNameEnum name;
    @Column(nullable = false)
    private String description;

    public LanguageNameEnum getName() {
        return name;
    }

    public void setName(LanguageNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
