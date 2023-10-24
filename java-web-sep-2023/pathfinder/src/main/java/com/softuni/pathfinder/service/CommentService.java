package com.softuni.pathfinder.service;

import com.softuni.pathfinder.model.dto.CommentCreationDTO;
import com.softuni.pathfinder.model.view.CommentDisplayView;

public interface CommentService {
    CommentDisplayView createComment(CommentCreationDTO commentCreationDTO);
}
