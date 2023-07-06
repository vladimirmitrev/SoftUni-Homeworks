package com.example.productshopxml.model.dto.seed;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySeedRootDto {

    @XmlElement(name = "category")
    private List<CategorySeedDto> categories;

    public List<CategorySeedDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategorySeedDto> categories) {
        this.categories = categories;
    }
}
