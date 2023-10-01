package com.softuni.mobilele.model.dto;

import com.softuni.mobilele.model.enums.EngineEnum;
import com.softuni.mobilele.model.enums.TransmissionEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AddOfferDTO {

    @NotNull
    private EngineEnum engine;

    @NotNull
    private TransmissionEnum transmission;
    @NotEmpty
    private String imageUrl;


    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
