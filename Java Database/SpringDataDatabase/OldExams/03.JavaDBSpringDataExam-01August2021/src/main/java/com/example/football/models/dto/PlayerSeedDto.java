package com.example.football.models.dto;

import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.models.entity.enums.Position;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerSeedDto {

    @XmlElement(name = "first-name")
    @Size(min = 2)
    private String firstName;

    @XmlElement(name = "last-name")
    @Size(min = 2)
    private String lastName;

    @XmlElement(name = "email")
    @Email
    private String email;

    @XmlElement(name = "birth-date")
    private String birthDate;

    @XmlElement(name = "position")
    @NotNull
    private Position position;

    @XmlElement(name = "town")
    private PlayerTownDto town;

    @XmlElement(name = "team")
    private PlayerTeamDto team;

    @XmlElement(name = "stat")
    private PlayerStatDto stat;

    public PlayerStatDto getStat() {
        return stat;
    }

    public void setStat(PlayerStatDto stat) {
        this.stat = stat;
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

    public PlayerTownDto getTown() {
        return town;
    }

    public void setTown(PlayerTownDto town) {
        this.town = town;
    }

    public PlayerTeamDto getTeam() {
        return team;
    }

    public void setTeam(PlayerTeamDto team) {
        this.team = team;
    }
}
