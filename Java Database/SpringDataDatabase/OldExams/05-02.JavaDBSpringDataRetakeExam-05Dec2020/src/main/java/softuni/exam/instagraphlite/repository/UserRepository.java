package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer > {
    Optional<User> findUserByUsername(String username);

    @Query("SELECT u FROM User u" +
            " ORDER BY size(u.posts) DESC, u.id ASC")
    List<User> findUserOrderByPostCount();
}
