package softuni.exam.models.entity.dto;

import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Seller;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class OfferSeedDto {

    @XmlElement(name = "description")
    @Size(min = 5)
    private String description;
    @XmlElement(name = "price")
    @Positive
    private BigDecimal price;
    @XmlElement(name = "added-on")
    private String addedOn;

    @XmlElement(name = "has-gold-status")
    private Boolean hasGoldStatus;

    @XmlElement(name = "car")
    private CarIdDTo car;

    @XmlElement(name = "seller")
    private SellerIdDto seller;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public Boolean getHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(Boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public CarIdDTo getCar() {
        return car;
    }

    public void setCar(CarIdDTo car) {
        this.car = car;
    }

    public SellerIdDto getSeller() {
        return seller;
    }

    public void setSeller(SellerIdDto seller) {
        this.seller = seller;
    }
}
