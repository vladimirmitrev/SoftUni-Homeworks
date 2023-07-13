package exam.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class CustomerImportDto {

    @Size(min = 2)
    private String firstName;
    @Size(min = 2)
    private String lastName;
    @Email
    private String email;

    private String registeredOn;

    private TownDto town;

    public CustomerImportDto() {
    }

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

    public String getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
    }

    public TownDto getTown() {
        return town;
    }

    public void setTown(TownDto town) {
        this.town = town;
    }

}
