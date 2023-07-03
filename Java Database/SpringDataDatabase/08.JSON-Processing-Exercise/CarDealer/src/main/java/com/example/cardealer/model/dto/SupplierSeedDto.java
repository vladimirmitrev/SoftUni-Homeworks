package com.example.cardealer.model.dto;

import com.google.gson.annotations.Expose;

public class SupplierSeedDto {

    @Expose
    private String name;
    @Expose
    private boolean isImporter;

    public SupplierSeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsImporter() {
        return isImporter;
    }

    public void setIsImporter(boolean isImporter) {
        this.isImporter = isImporter;
    }
}
