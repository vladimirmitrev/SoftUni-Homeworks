package com.example.cardealer.model.dto;

import com.google.gson.annotations.Expose;

public class SupplierWithIdAndPartsCountDto {
    @Expose
    private long id;

    @Expose
    private String name;

    @Expose
    private long partsCount;

    public SupplierWithIdAndPartsCountDto() {
    }

    public SupplierWithIdAndPartsCountDto(long id, String name, long partsCount) {
        this.id = id;
        this.name = name;
        this.partsCount = partsCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(long partsCount) {
        this.partsCount = partsCount;
    }
}
