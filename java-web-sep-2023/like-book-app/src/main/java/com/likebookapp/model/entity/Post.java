package com.likebookapp.model.entity;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {


    @Length(min = 2, max = 150)
    @Column(nullable = false)
    private String content;

    @ManyToOne
    private User creator;

    @ManyToOne
    private Mood mood;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> userLikes;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<User> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(List<User> userLikes) {
        this.userLikes = userLikes;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }
}
