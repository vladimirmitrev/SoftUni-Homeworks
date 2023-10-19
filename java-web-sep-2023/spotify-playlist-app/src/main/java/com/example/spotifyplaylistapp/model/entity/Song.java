package com.example.spotifyplaylistapp.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "songs")
public class Song extends BaseEntity {

    @Length(min = 3, max = 20)
    @Column(nullable = false)
    private String performer;

    @Length(min = 2, max = 20)
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Positive
    private int duration;

    @PastOrPresent
    private LocalDate releaseDate;

    @ManyToOne
    private Style style;

    @ManyToMany
    private List<User> users;

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
