package com.example.football.models.dto;

import com.example.football.models.entity.Town;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeamImportDto {

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    @Size(min = 3)
    private String stadiumName;

    @NotNull
    @Min(1000)
    private Integer fanBase;

    @NotNull
    @Size(min = 10)
    private String history;

    @NotNull
    private String townName;

    public TeamImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public Integer getFanBase() {
        return fanBase;
    }

    public void setFanBase(Integer fanBase) {
        this.fanBase = fanBase;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
