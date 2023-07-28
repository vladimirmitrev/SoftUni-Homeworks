package softuni.exam.models.dto;

import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Part;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskImportDto {

    @XmlElement
    @NotNull
    @Positive
    private BigDecimal price;


    @XmlElement
    @NotNull
    private String date;


    @XmlElement
    @NotNull
    private MechanicXmlDto mechanic;

    @XmlElement
    @NotNull
    private CarXmlDto car;

    @XmlElement
    @NotNull
    private PartXmlDto part;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MechanicXmlDto getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicXmlDto mechanic) {
        this.mechanic = mechanic;
    }

    public CarXmlDto getCar() {
        return car;
    }

    public void setCar(CarXmlDto car) {
        this.car = car;
    }

    public PartXmlDto getPart() {
        return part;
    }

    public void setPart(PartXmlDto part) {
        this.part = part;
    }
}
