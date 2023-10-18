package com.likebookapp.model.dto.post;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.User;

import java.util.List;

public class PostViewDTO {

    private Long id;
    private String content;
    private Mood mood;
    private String username;
    private List<User> userLikes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<User> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(List<User> userLikes) {
        this.userLikes = userLikes;
    }

    public boolean checkIfUserIdMatchId(Long userId){
        return this.getUserLikes().stream()
                .anyMatch(user -> {
                    boolean r = user.getId().equals(userId);
                    return r;
                });
    }
}
