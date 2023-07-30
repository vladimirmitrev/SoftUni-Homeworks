package softuni.exam.models.dto;

import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.StarType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class StarImportDto {

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    @Positive
    private Double lightYears;

    @NotNull
    @Size(min = 6)
    private String description;

    @NotNull
    private StarType starType;

    @NotNull
    private Long constellation;

    public StarImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StarType getStarType() {
        return starType;
    }

    public void setStarType(StarType starType) {
        this.starType = starType;
    }

    public Long getConstellation() {
        return constellation;
    }

    public void setConstellation(Long constellation) {
        this.constellation = constellation;
    }
}
