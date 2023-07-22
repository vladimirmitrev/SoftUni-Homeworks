package com.example.football.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stats")
public class Stat extends BaseEntity {

    @Column(nullable = false)
    private float shooting;

    @Column(nullable = false)
    private float passing;

    @Column(nullable = false)
    private float endurance;

    @OneToMany(mappedBy = "stat")
    private Set<Player> players;


    public Stat() {
    }

    public float getShooting() {
        return shooting;
    }

    public void setShooting(float shooting) {
        this.shooting = shooting;
    }

    public float getPassing() {
        return passing;
    }

    public void setPassing(float passing) {
        this.passing = passing;
    }

    public float getEndurance() {
        return endurance;
    }

    public void setEndurance(float endurance) {
        this.endurance = endurance;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}

