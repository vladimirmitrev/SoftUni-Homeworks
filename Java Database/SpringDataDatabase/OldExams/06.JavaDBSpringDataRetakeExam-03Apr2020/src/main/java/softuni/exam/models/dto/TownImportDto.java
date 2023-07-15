package softuni.exam.models.dto;

import javax.persistence.Column;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TownImportDto {

    @Size(min = 2)
    private String name;

    @Positive
    private int population;

    private String guide;

    public TownImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }
}
