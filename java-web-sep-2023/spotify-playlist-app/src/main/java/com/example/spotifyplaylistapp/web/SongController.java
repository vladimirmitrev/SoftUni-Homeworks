package com.example.spotifyplaylistapp.web;

import com.example.spotifyplaylistapp.model.dto.song.SongAddBindingModel;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    private final UserService userService;
    private final LoggedUser loggedUser;

    public SongController(SongService songService, UserService userService, LoggedUser loggedUser) {
        this.songService = songService;
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("songAddBindingModel")
    public SongAddBindingModel initSongModel() {
        return new SongAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {

        if(!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }


        return "song-add";
    }

    @PostMapping("/add")
    public String confirmAddSong(@Valid SongAddBindingModel songAddBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes)  {

        if(!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        if(bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("songAddBindingModel", songAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.songAddBindingModel",
                    bindingResult);

            return "redirect:add";
        }

        songService.addSong(songAddBindingModel);

        return "redirect:/home";
    }

    @GetMapping("/add-song-to-playlist/{id}")
    String addSongToPlaylist(@PathVariable Long id) {

        if(!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        userService.addSongToPlaylist(id, loggedUser.getId());

        return "redirect:/home";
    }
    @GetMapping("/remove-all")
    public String removeAll() {

        if(!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        userService.removeAllSongs();

        return "redirect:/home";
    }


}
