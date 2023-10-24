package com.softuni.pathfinder.web.rest;


import com.softuni.pathfinder.exeptions.RouteNotFoundException;
import com.softuni.pathfinder.model.dto.CommentCreationDTO;
import com.softuni.pathfinder.model.dto.CommentMessageDTO;
import com.softuni.pathfinder.model.view.CommentDisplayView;
import com.softuni.pathfinder.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentRestController {

    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{routeId}/comments")
    public ResponseEntity<List<CommentDisplayView>> getComments(@PathVariable("routeId") Long routeId) {

        return ResponseEntity.ok(commentService.getAllCommentsForRoute(routeId));

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

    @ExceptionHandler({RouteNotFoundException.class})
    public ResponseEntity<ErrorApiResponse> handleRouteNotFound() {
        return ResponseEntity
                .status(404)
                .body(new ErrorApiResponse("Such a route doesn't exist!", 1004)); //my error code
    }
}

class ErrorApiResponse {
    private String message;
    private Integer errorCode;

    ErrorApiResponse(String message, Integer errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}

