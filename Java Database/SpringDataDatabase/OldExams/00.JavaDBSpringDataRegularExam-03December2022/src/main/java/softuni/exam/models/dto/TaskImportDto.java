package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskImportDto {

//    @NotNull
    @XmlElement
    @Positive
    private BigDecimal price;

//    @NotNull
    @XmlElement
    private String date;
    @XmlElement
    private CarIdDto car;

    @XmlElement
    private MechanicFirstNameDto mechanic;

    @XmlElement
    private PartIdDto part;


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

    public MechanicFirstNameDto getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicFirstNameDto mechanic) {
        this.mechanic = mechanic;
    }

    public PartIdDto getPart() {
        return part;
    }

    public void setPart(PartIdDto part) {
        this.part = part;
    }

    public CarIdDto getCar() {
        return car;
    }

    public void setCar(CarIdDto car) {
        this.car = car;
    }
}
