package exam.repository;

import exam.model.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    Optional<Laptop> findLaptopByMacAddress(String macAddress);

    List<Laptop> findLaptopByIdIsNotNullOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc();
}
