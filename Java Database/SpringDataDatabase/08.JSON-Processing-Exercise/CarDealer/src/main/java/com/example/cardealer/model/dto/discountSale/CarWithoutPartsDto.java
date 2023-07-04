package com.example.cardealer.model.dto.discountSale;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarWithoutPartsDto {

    @Expose
    @SerializedName("Make")
    private String make;
    @Expose
    @SerializedName("Model")
    private String model;

    @Expose
    @SerializedName("TravelledDistance")
    private Long travelledDistance;

    public CarWithoutPartsDto() {
    }

    public CarWithoutPartsDto(String make, String model, Long travelledDistance) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
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

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
}
