package com.example.cardealer.model.dto.discountSale;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

public class CarDto {

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private long travelledDistance;

    @Expose
    private Set<PartDto> parts;

    public CarDto() {
    }

    public CarDto(String make, String model, long travelledDistance, Set<PartDto> parts) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
        this.parts = parts;
    }

    public BigDecimal getCarPrice(){
        return parts
                .stream()
                .map(PartDto::getPrice)
                .reduce(BigDecimal.ONE, BigDecimal::add );
    }

    public CarWithPartsDto carWithPartsDto(){
        CarWithoutPartsDto car = new CarWithoutPartsDto(make, model, travelledDistance);

        Set<PartWithNameDto> parts =
                this.parts
                        .stream()
                        .map(CarDto::partWithNameDto)
                        .collect(Collectors.toSet());

        return new CarWithPartsDto(car, parts);
    }

    public static PartWithNameDto partWithNameDto(PartDto partDto){
        return new PartWithNameDto(partDto.getName(), partDto.getPrice());
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

    public Set<PartDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartDto> parts) {
        this.parts = parts;
    }
}
