package softuni.exam.models.dto;

import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Plane;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketImportDto {

    @Size(min = 2)
    @XmlElement(name = "serial-number")
    private String serialNumber;

    @Positive
    @XmlElement
    private BigDecimal price;


    @XmlElement(name = "take-off")
    private String takeOff;

    @XmlElement(name = "from-town")
    private FromTownDto fromTown;

    @XmlElement(name = "to-town")
    private ToTownDto toTown;

    @XmlElement
    private PassengerEmailDto passenger;

    @XmlElement
    private PlaneDto plane;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(String takeOff) {
        this.takeOff = takeOff;
    }

    public FromTownDto getFromTown() {
        return fromTown;
    }

    public void setFromTown(FromTownDto fromTown) {
        this.fromTown = fromTown;
    }

    public ToTownDto getToTown() {
        return toTown;
    }

    public void setToTown(ToTownDto toTown) {
        this.toTown = toTown;
    }

    public PassengerEmailDto getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerEmailDto passenger) {
        this.passenger = passenger;
    }

    public PlaneDto getPlane() {
        return plane;
    }

    public void setPlane(PlaneDto plane) {
        this.plane = plane;
    }
}
