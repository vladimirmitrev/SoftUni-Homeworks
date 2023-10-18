package com.likebookapp.model.entity;

import com.likebookapp.model.entity.enums.MoodNameEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "moods")
public class Mood extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private MoodNameEnum name;
    private String description;

    @OneToMany(mappedBy = "mood")
    private List<Post> posts;

    public MoodNameEnum getName() {
        return name;
    }

    public void setName(MoodNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
