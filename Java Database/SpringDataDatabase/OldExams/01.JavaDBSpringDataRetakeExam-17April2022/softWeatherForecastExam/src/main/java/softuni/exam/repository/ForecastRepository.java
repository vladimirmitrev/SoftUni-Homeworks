package softuni.exam.repository;

// TODO:

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.enums.DayOfWeek;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    Optional<Forecast> findAllByCityAndDayOfWeek(City city, DayOfWeek dayOfWeek);

    Set<Forecast> findAllByDayOfWeekAndCity_PopulationLessThanOrderByMaxTemperatureDescIdAsc(DayOfWeek dayOfWeek, int city_population);
}
