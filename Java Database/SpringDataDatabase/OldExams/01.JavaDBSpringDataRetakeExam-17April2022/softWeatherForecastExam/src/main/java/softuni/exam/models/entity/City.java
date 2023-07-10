package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cities")
public class City extends BaseEntity {


    @Column(name = "city_name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "population", nullable = false)
    private int population;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "city")
    private Set<Forecast> forecasts;

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(Set<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    //•	city name – a char sequence (between 2 to 60 inclusive). The values are unique in the database. Cannot be null.
    //•	description – accepts very long char sequence (min 2 symbols).
    //•	population – accepts number values that are more than or equal to 500. Cannot be null.
    //•	Constraint: The cities table has а relation with the countries table.
}
