package com.softuni.mobilele.model.dto.brand;

import com.softuni.mobilele.model.dto.model.ModelDTO;

import java.util.ArrayList;
import java.util.List;

public class BrandDTO {

    private String name;
    private List<ModelDTO> models;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModelDTO> getModels() {
        return models;
    }

    public void setModels(List<ModelDTO> models) {
        this.models = models;
    }

    public BrandDTO addModel(ModelDTO model) {

        if (this.models == null) {
            this.models = new ArrayList<>();
        }
        this.models.add(model);

        return this;
    }
}
