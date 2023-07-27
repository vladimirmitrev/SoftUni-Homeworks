package softuni.exam.models.dtos;

import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Picture;
import softuni.exam.models.entities.Seller;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferImportDto {

    @XmlElement
    @Positive
    private BigDecimal price;

    @XmlElement
    @Size(min = 5)
    private String description;

    @XmlElement(name = "has-gold-status")
    private String hasGoldStatus;

    @XmlElement(name = "added-on")
    private String addedOn;

    @XmlElement
    private CarDto car;

    @XmlElement
    private SellerDto seller;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(String hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }

    public SellerDto getSeller() {
        return seller;
    }

    public void setSeller(SellerDto seller) {
        this.seller = seller;
    }
}
