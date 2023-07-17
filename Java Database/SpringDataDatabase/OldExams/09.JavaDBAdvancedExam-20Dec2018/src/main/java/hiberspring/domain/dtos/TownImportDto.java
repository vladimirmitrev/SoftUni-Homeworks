package hiberspring.domain.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class TownImportDto {

    @NotNull
    private String name;
    @NotNull
    @Positive
    private int population;

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
}
