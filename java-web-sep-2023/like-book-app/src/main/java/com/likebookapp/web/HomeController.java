package com.likebookapp.web;

import com.likebookapp.model.dto.post.PostViewDTO;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.service.PostService;
import com.likebookapp.service.UserService;
import com.likebookapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final PostService postService;
    private final UserService userService;

    public HomeController(LoggedUser loggedUser, PostService postService, UserService userService) {
        this.loggedUser = loggedUser;
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {

        if(loggedUser.isLogged()) {
            return ("redirect:/home");
        }

        return ("index");
    }

    @GetMapping("/home")
    public String home(Model model) {

        if (!loggedUser.isLogged()) {
            return "redirect:/";
        }

        User user = userService.findUserById(loggedUser.getId()).orElse(null);
//        model.addAttribute("currentUserInfo", user);
        model.addAttribute("user", user);

        List<Post> postsFromCurrentUser = postService.getPostsFromCurrentUser(loggedUser.getId());
        model.addAttribute("userPosts", postsFromCurrentUser);

        List<PostViewDTO> postsFromOtherUsers = this.postService.getPostsFromOtherUsers(this.loggedUser.getId());
        model.addAttribute("otherUserPosts", postsFromOtherUsers);

        return "home";
    }
}
