package com.softuni.pathfinder.service.impl;

import com.softuni.pathfinder.model.dto.CommentCreationDTO;
import com.softuni.pathfinder.model.entity.CommentEntity;
import com.softuni.pathfinder.model.entity.RouteEntity;
import com.softuni.pathfinder.model.entity.UserEntity;
import com.softuni.pathfinder.model.view.CommentDisplayView;
import com.softuni.pathfinder.repository.CommentRepository;
import com.softuni.pathfinder.repository.RouteRepository;
import com.softuni.pathfinder.repository.UserRepository;
import com.softuni.pathfinder.service.CommentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService {

    private final RouteRepository routeRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public CommentServiceImpl(RouteRepository routeRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDisplayView createComment(CommentCreationDTO commentCreationDTO) {

        RouteEntity route = routeRepository
                .findById(commentCreationDTO.getRouteId())
                .orElse(null);

        UserEntity author = userRepository
                .findByUsername(commentCreationDTO.getUsername())
                .get();


        CommentEntity comment = new CommentEntity();
        comment.setCreated(LocalDateTime.now());
        comment.setRoute(route);
        comment.setAuthor(author);
        comment.setApproved(true);
        comment.setTextContent(commentCreationDTO.getMessage());

        commentRepository.save(comment);

        return new CommentDisplayView(comment.getId(),author.getFullName(), comment.getTextContent());

    }
}
