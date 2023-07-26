package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Passenger;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    Optional<Passenger> findPassengerByEmail(String email);


    @Query("SELECT p FROM Passenger p" +
            " ORDER BY p.tickets.size DESC, p.email ASC")
    List<Passenger> getAllPassengersOrderByTicketCount();
}
