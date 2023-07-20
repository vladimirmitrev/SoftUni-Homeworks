package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.DayOfWeek;
import softuni.exam.models.entity.Forecast;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    Optional<Forecast> findForecastByDayOfWeekAndCityId(DayOfWeek day, Long id);


    List<Forecast> findForecastByDayOfWeekAndCity_PopulationLessThanOrderByMaxTemperatureDescIdAsc(DayOfWeek dayOfWeek, int population);


//    @Query("SELECT f FROM Forecast f" +
//            " WHERE f.dayOfWeek = :dayOfWeek" +
//            " AND f.city.population < :population" +
//            " ORDER BY f.maxTemperature DESC, f.id ASC")
//    List<Forecast> findForecastByDayOfWeekAndCity(DayOfWeek dayOfWeek, int population);
}
