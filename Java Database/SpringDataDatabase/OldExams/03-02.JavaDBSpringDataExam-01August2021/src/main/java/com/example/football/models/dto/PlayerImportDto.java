package com.example.football.models.dto;

import com.example.football.models.entity.Position;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerImportDto {


    @NotNull
    @Size(min = 2)
    @XmlElement(name = "first-name")
    private String firstName;

    @NotNull
    @Size(min = 2)
    @XmlElement(name = "last-name")
    private String lastName;

    @NotNull
    @Email
    private String email;

    @NotNull
    @XmlElement(name = "birth-date")
    private String birthDate;

    @NotNull
    private Position position;

    @NotNull
    private TownDto town;
    @NotNull
    private TeamDto team;
    @NotNull
    private StatDto stat;

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public TownDto getTown() {
        return town;
    }

    public void setTown(TownDto town) {
        this.town = town;
    }

    public TeamDto getTeam() {
        return team;
    }

    public void setTeam(TeamDto team) {
        this.team = team;
    }

    public StatDto getStat() {
        return stat;
    }

    public void setStat(StatDto stat) {
        this.stat = stat;
    }
}
