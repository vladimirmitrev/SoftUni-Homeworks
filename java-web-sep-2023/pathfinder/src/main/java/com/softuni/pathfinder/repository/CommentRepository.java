package com.softuni.pathfinder.repository;

import com.softuni.pathfinder.model.entity.CommentEntity;
import com.softuni.pathfinder.model.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findAllByRoute(RouteEntity route);
}
