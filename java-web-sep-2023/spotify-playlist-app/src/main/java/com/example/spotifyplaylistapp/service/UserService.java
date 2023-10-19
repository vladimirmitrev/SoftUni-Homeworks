package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dto.song.SongViewAllDTO;
import com.example.spotifyplaylistapp.model.dto.user.UserLoginBindingModel;
import com.example.spotifyplaylistapp.model.dto.user.UserRegisterBindingModel;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.util.LoggedUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;
    private final SongService songService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser, SongService songService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
        this.songService = songService;
    }

    public boolean findByUsernameOrEmail(String username, String email) {

        return userRepository
                .findByUsernameOrEmail(username,email)
                .isPresent();
    }

    public void registerUser(UserRegisterBindingModel userRegisterBindingModel) {

        User user = new User();
        user.setUsername(userRegisterBindingModel.getUsername());
        user.setEmail(userRegisterBindingModel.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));

        userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean login(UserLoginBindingModel userLoginBindingModel) {

        String username = userLoginBindingModel.getUsername();

        User user = userRepository
                .findByUsername(userLoginBindingModel.getUsername())
                .orElse(null);

        if(user != null
                && passwordEncoder.matches(userLoginBindingModel.getPassword(),user.getPassword())) {

            loggedUser.setId(user.getId());
            loggedUser.setUsername(user.getUsername());
            loggedUser.login(username);

            return true;
        }
        return false;
    }

    public void logout() {
        this.loggedUser.logout();
    }

    public void removeAllSongs() {

        User user = userRepository
                .findById(loggedUser.getId())
                .orElse(null);

        user.deleteAllSongFromUserSongs();

        userRepository.save(user);
    }

    public void addSongToPlaylist(Long songId, Long userId) {

        User user = userRepository.findById(userId).orElse(null);

        Song song = songService.findSongById(songId);

        if(user.getUserSongs().stream().anyMatch(song1 -> song1.getId().equals(songId))) {
            return;
        }

        user.addSongToPlaylist(song);

        userRepository.save(user);
    }

    public List<SongViewAllDTO> getUserPlaylist() {

        User user = userRepository.findById(loggedUser.getId()).orElse(null);

       return user.getUserSongs().stream()
               .map(song -> {
                   SongViewAllDTO songViewAllDTO = new SongViewAllDTO();
                   songViewAllDTO.setId(song.getId());
                   songViewAllDTO.setPerformer(song.getPerformer());
                   songViewAllDTO.setTitle(song.getTitle());
                   songViewAllDTO.setDuration(song.getDuration());
                   songViewAllDTO.setStyle(song.getStyle());

                   return songViewAllDTO;
               }).collect(Collectors.toList());
    }
}
