package com.softuni.pathfinder.repository;

import com.softuni.pathfinder.model.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
