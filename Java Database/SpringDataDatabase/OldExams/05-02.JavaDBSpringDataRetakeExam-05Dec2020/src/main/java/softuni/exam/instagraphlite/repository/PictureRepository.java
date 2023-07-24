package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.entities.Picture;

import java.util.List;
import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
    Optional<Picture> findPictureByPath(String path);

    List<Picture> findPictureBySizeGreaterThanOrderBySizeAsc(double picSize);
}
