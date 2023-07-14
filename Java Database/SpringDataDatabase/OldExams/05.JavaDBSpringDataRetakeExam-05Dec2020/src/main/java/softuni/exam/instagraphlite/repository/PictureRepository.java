package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.entity.Picture;

import java.util.List;
import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
    Optional<Picture> findPictureByPath(String path);

    @Query("SELECT p from Picture p" +
            " WHERE p.size > 30000" +
            " ORDER BY p.size ASC")
    List<Picture> findAllPicturesOrderBySize();

//    List<Picture> findAllPictureGreaterThanOrderBySize(double size);
}
