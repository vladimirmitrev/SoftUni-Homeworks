package com.example.cardealer.model.dto.discountSale;

import com.example.cardealer.model.dto.discountSale.PartDto;
import com.google.gson.annotations.Expose;

import java.util.Set;

public class SupplierDto {
    @Expose
    private String name;
    @Expose

    private boolean isImporter;
    @Expose

    Set<PartDto> parts;

    public SupplierDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }

    public Set<PartDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartDto> parts) {
        this.parts = parts;
    }
}
