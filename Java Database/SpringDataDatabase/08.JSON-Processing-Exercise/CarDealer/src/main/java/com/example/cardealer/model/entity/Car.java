package com.example.cardealer.model.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    @Column
    private String make;
    @Column
    private String model;
    @Column(name = "travelled_distance")
    private long travelledDistance;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cars_parts",
    joinColumns = @JoinColumn(name = "car_id"),
    inverseJoinColumns = @JoinColumn(name = "part_id"))
    private Set<Part> parts;

    public Car() {
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

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return travelledDistance == car.travelledDistance && Objects.equals(make, car.make) && Objects.equals(model, car.model) && Objects.equals(parts, car.parts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, travelledDistance, parts);
    }
}
