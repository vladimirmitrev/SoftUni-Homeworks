package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByEmail(String email);

    List<Player> findAllByBirthDateAfterAndBirthDateBeforeOrderByStatShootingDescStatPassingDescStatEnduranceDescLastNameAsc(LocalDate after, LocalDate before);

    //Other working queries
// #1
//    @Query("SELECT p FROM Player p" +
//            " WHERE p.birthDate > :after AND p.birthDate < :before " +
//            " ORDER BY p.stat.shooting DESC, p.stat.passing DESC, p.stat.endurance DESC, p.lastName ASC")

// #2
//    List<Player> findAllByBirthDateAfterAndBirthDateBeforeOrderByStatAndLastName(@Param("after") LocalDate after, @Param("before") LocalDate before);

// #3
    //    List<Player> findAllByBirthDateAfterAndBirthDateBeforeOrderByStat_ShootingDesc(LocalDate after, LocalDate before);

    // #4

//    List<Player> findAllByBirthDateBetweenOrderByStatShootingDescStatPassingDescStatEnduranceDescLastNameAsc(LocalDate after, LocalDate before);


}
