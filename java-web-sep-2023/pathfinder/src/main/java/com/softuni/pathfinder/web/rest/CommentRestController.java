package com.softuni.pathfinder.web.rest;


import com.softuni.pathfinder.model.dto.CommentCreationDTO;
import com.softuni.pathfinder.model.dto.CommentMessageDTO;
import com.softuni.pathfinder.model.view.CommentDisplayView;
import com.softuni.pathfinder.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class CommentRestController {

    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/{routeId}/comments",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<CommentDisplayView> createComment(@PathVariable("routeId") Long routeId,
                                                            @AuthenticationPrincipal UserDetails userDetails,
                                                            @RequestBody CommentMessageDTO commentDTO) {

        CommentCreationDTO commentCreationDTO = new CommentCreationDTO(
                userDetails.getUsername(),
                routeId,
                commentDTO.getMessage()
        );

        CommentDisplayView comment = commentService.createComment(commentCreationDTO);


        return ResponseEntity
                .created(URI.create(String.format("/api/%d/comments/%d", routeId, comment.getId())))
                .body(comment);
    }
}
