package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Ticket;

import java.util.Optional;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findTicketBySerialNumber(String serialNumber);
}
