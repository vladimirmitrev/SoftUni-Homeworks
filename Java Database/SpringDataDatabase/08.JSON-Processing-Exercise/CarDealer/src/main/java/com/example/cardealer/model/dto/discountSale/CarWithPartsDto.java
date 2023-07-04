package com.example.cardealer.model.dto.discountSale;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class CarWithPartsDto {

    @Expose
    private CarWithoutPartsDto car;
    @Expose
    public Set<PartWithNameDto> parts;

    public CarWithPartsDto() {
    }


    public CarWithPartsDto(CarWithoutPartsDto car, Set<PartWithNameDto> parts) {
        this.car = car;
        this.parts = parts;
    }

    public CarWithoutPartsDto getCar() {
        return car;
    }

    public void setCar(CarWithoutPartsDto car) {
        this.car = car;
    }

    public Set<PartWithNameDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartWithNameDto> parts) {
        this.parts = parts;
    }
}
