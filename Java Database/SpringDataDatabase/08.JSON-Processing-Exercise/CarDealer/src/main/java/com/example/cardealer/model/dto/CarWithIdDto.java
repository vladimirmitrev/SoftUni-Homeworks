package com.example.cardealer.model.dto;

import com.google.gson.annotations.Expose;

public class CarWithIdDto {
    @Expose
    private long id;
    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private long travelledDistance;

    public CarWithIdDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
}
