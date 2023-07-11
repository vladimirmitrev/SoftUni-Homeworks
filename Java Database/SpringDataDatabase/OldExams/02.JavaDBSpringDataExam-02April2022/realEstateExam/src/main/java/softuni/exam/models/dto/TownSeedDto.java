package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TownSeedDto {

    @Expose
    @Size(min = 2)
    private String townName;
    @Expose
    @Positive
    private Integer population;

    public TownSeedDto() {
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    // "townName": "Matingain",
    //    "population": 2162142
}
