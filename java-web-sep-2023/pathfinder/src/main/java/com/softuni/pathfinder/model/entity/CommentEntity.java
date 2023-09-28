package com.softuni.pathfinder.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

    private Boolean approved;
    private LocalDateTime created;
    @Column(columnDefinition = "LONGTEXT")
    private String textContent;

    @ManyToOne
    private UserEntity author;
    @ManyToOne
    private UserEntity route;

    public CommentEntity() {
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public UserEntity getRoute() {
        return route;
    }

    public void setRoute(UserEntity route) {
        this.route = route;
    }
}
