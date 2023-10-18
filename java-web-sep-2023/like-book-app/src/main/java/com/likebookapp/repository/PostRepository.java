package com.likebookapp.repository;

import com.likebookapp.model.dto.post.PostViewDTO;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByCreatorId(Long id);

    List<Post> findAllByCreator_IdNot(Long id);
}
