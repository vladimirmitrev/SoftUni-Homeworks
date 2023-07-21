package softuni.exam.models.dto;

import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDate;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferImportDto {

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private String publishedOn;

    @NotNull
    private ApartmentDto apartment;

    @NotNull
    private AgentDto agent;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    public ApartmentDto getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentDto apartment) {
        this.apartment = apartment;
    }

    public AgentDto getAgent() {
        return agent;
    }

    public void setAgent(AgentDto agent) {
        this.agent = agent;
    }
}
