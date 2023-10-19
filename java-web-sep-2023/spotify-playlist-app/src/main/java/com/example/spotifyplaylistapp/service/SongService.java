package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dto.song.SongAddBindingModel;
import com.example.spotifyplaylistapp.model.dto.song.SongViewAllDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {

    private final StyleRepository styleRepository;
    private final SongRepository songRepository;

    public SongService(StyleRepository styleRepository, SongRepository songRepository) {
        this.styleRepository = styleRepository;
        this.songRepository = songRepository;
    }

    public void addSong(SongAddBindingModel songAddBindingModel) {

        Style style = styleRepository.findByName(songAddBindingModel.getStyle());

        if (style != null) {
            Song song = new Song();
            song.setPerformer(songAddBindingModel.getPerformer());
            song.setTitle(songAddBindingModel.getTitle());
            song.setReleaseDate(songAddBindingModel.getReleaseDate());
            song.setDuration(songAddBindingModel.getDuration());
            song.setStyle(style);

            songRepository.save(song);
        }
    }

    public List<SongViewAllDTO> getAllSongs() {

        List<SongViewAllDTO> allSongs = songRepository.findAll()
                .stream()
                .map(this::mapSongDTO)
                .collect(Collectors.toList());

        return allSongs;
    }

    public List<SongViewAllDTO> getPopSongs(StyleNameEnum pop) {

        return songRepository.findSongByStyleName(pop)
                .stream()
                .map(this::mapSongDTO)
                .collect(Collectors.toList());
    }

    public List<SongViewAllDTO> getRockSongs(StyleNameEnum rock) {

        return songRepository.findSongByStyleName(rock)
                .stream()
                .map(this::mapSongDTO)
                .collect(Collectors.toList());
    }

    public List<SongViewAllDTO> getJazzSongs(StyleNameEnum jazz) {

        return songRepository.findSongByStyleName(jazz)
                .stream()
                .map(this::mapSongDTO)
                .collect(Collectors.toList());
    }

    private SongViewAllDTO mapSongDTO(Song song) {
        SongViewAllDTO songViewAllDTO = new SongViewAllDTO();
        songViewAllDTO.setId(song.getId());
        songViewAllDTO.setPerformer(song.getPerformer());
        songViewAllDTO.setTitle(song.getTitle());
        songViewAllDTO.setDuration(song.getDuration());
        songViewAllDTO.setStyle(song.getStyle());

        return songViewAllDTO;
    }


    public Song findSongById(Long songId) {

            return songRepository
                    .findById(songId).orElse(null);
    }

}
