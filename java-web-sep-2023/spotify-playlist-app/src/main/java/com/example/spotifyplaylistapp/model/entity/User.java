package com.example.spotifyplaylistapp.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Length(min = 3, max = 20)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Song> userSongs;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Song> getUserSongs() {
        return userSongs;
    }

    public void setUserSongs(List<Song> userSongs) {
        this.userSongs = userSongs;
    }

    public void addSongToPlaylist(Song song) {
        this.userSongs.add(song);
    }

    public void deleteAllSongFromUserSongs() {
        this.userSongs.clear();
    }

}
