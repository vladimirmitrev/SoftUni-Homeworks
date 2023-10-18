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

    @ManyToMany
    private List<User> likes;

    @ManyToOne
    private Mood mood;

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

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }
}
