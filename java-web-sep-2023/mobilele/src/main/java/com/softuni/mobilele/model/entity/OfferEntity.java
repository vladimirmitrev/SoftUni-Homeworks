package com.softuni.mobilele.model.entity;

import com.softuni.mobilele.model.enums.EngineEnum;
import com.softuni.mobilele.model.enums.TransmissionEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EngineEnum engine;
    @Column(nullable = false)
    private String imageUrl;
    @Column(nullable = false)
    private Integer mileage;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;
    @Column(nullable = false)
    private Integer year;

    @ManyToOne
    private ModelEntity model;

    @ManyToOne
    private UserEntity seller;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

//    @Override
//    public String toString() {
//        return "OfferEntity{" +
//                "description='" + description + '\'' +
//                ", engine=" + engine +
//                ", imageUrl='" + imageUrl + '\'' +
//                ", mileage=" + mileage +
//                ", price=" + price +
//                ", transmission=" + transmission +
//                ", year=" + year +
//                ", model=" + model +
//                ", seller=" + seller +
//                '}';
//    }
}
