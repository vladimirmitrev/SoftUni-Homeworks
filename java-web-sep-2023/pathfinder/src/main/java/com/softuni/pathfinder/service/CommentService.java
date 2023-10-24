package com.softuni.pathfinder.service;

import com.softuni.pathfinder.model.dto.CommentCreationDTO;
import com.softuni.pathfinder.model.view.CommentDisplayView;

import java.util.List;

public interface CommentService {
    CommentDisplayView createComment(CommentCreationDTO commentCreationDTO);

    List<CommentDisplayView> getAllCommentsForRoute(Long routeId);
}
