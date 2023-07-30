package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.StarType;

import java.util.List;
import java.util.Optional;

// TODO:
@Repository
public interface StarRepository extends JpaRepository<Star, Long> {

    Optional<Star> findByName(String name);

    List<Star> findByStarTypeAndObserversEmptyOrderByLightYears(StarType starType);


//    @Query("SELECT s FROM Star s" +
//            " WHERE size(s.observers) = 0" +
//            " AND s.starType = :starType" +
//            " ORDER BY s.lightYears")
//    List<Star> findByStarTypeAndObserversEmptyOrderByLightYears(StarType starType);


}
