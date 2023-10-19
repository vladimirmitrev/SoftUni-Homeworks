package com.example.spotifyplaylistapp.web;

import com.example.spotifyplaylistapp.model.dto.song.SongViewAllDTO;
import com.example.spotifyplaylistapp.model.dto.song.SongViewUserSongsDTO;
import com.example.spotifyplaylistapp.model.entity.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final SongService songService;
    private final UserService userService;

    public HomeController(LoggedUser loggedUser, SongService songService, UserService userService) {
        this.loggedUser = loggedUser;
        this.songService = songService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {

        if (loggedUser.isLogged()) {
            return ("redirect:/home");
        }

        return ("index");
    }

    @GetMapping("/home")
    public String home(Model model) {

        if (!loggedUser.isLogged()) {
            return "redirect:/";
        }


        List<SongViewAllDTO> playlist = this.userService.getUserPlaylist();
        model.addAttribute("playlist", playlist);
        model.addAttribute("totalPlaylistDuration", playlist.stream()
                .map(SongViewAllDTO::getDuration)
                .reduce(Integer::sum)
                .orElse(null));

        List<SongViewAllDTO> popSongs = this.songService.getPopSongs(StyleNameEnum.POP);
        model.addAttribute("popSongs", popSongs);

        List<SongViewAllDTO> rockSongs = this.songService.getRockSongs(StyleNameEnum.ROCK);
        model.addAttribute("rockSongs", rockSongs);

        List<SongViewAllDTO> jazzSongs = this.songService.getJazzSongs(StyleNameEnum.JAZZ);
        model.addAttribute("jazzSongs", jazzSongs);

        return "home";
    }


}
