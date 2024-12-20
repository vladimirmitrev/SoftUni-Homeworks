package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Car;

import java.util.Optional;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {

    Optional<Car> findCarByPlateNumber(String plateNumber);

    Car findCarById(Long id);
}
