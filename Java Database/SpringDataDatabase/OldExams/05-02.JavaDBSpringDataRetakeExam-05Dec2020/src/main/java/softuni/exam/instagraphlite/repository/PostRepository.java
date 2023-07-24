package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.entities.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT p FROM Post p" +
            " WHERE p.user.id = :id" +
            " ORDER BY p.picture.size ASC")
    List<Post> findAllOrderByPictureSize(int id);
}
