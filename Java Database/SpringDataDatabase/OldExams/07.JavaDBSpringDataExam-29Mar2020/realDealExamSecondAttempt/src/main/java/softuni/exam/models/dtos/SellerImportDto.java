package softuni.exam.models.dtos;

import softuni.exam.models.entities.Rating;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "seller")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerImportDto {

    @XmlElement(name = "first-name")
    @Size(min = 2, max = 19)
    private String firstName;

    @XmlElement(name = "last-name")
    @Size(min = 2, max = 19)
    private String lastName;

    @XmlElement
    @Email
    private String email;

    @XmlElement
    @NotNull
    private Rating rating;

    @XmlElement
    @NotBlank
    private String town;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
