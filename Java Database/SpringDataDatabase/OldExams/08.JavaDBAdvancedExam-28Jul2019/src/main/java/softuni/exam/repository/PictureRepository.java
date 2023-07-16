package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.domain.entities.Picture;

import java.util.Optional;

@Repository
public interface PictureRepository  extends JpaRepository<Picture, Integer> {

    Optional<Picture> findPictureByUrl(String url);
}
