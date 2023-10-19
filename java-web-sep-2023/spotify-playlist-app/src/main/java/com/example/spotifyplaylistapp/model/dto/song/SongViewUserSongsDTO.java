package com.example.spotifyplaylistapp.model.dto.song;

import com.example.spotifyplaylistapp.model.entity.Song;

import java.util.List;

public class SongViewUserSongsDTO {

    private List<Song> userSongs;

    public List<Song> getUserSongs() {
        return userSongs;
    }

    public void setUserSongs(List<Song> userSongs) {
        this.userSongs = userSongs;
    }
}
