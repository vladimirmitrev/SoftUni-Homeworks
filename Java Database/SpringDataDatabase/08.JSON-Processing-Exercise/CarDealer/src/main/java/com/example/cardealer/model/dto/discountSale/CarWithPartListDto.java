package com.example.cardealer.model.dto.discountSale;

import com.google.gson.annotations.Expose;

import java.util.List;

public class CarWithPartListDto {

    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private long TravelledDistance;

    @Expose
    private List<PartNameAndPriceDto> parts;

    public CarWithPartListDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getTravelledDistance() {
        return TravelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        TravelledDistance = travelledDistance;
    }

    public List<PartNameAndPriceDto> getParts() {
        return parts;
    }

    public void setParts(List<PartNameAndPriceDto> parts) {
        this.parts = parts;
    }
}
