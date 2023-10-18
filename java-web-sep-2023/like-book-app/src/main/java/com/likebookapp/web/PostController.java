package com.likebookapp.web;

import com.likebookapp.model.dto.post.PostAddBindingModel;
import com.likebookapp.service.PostService;
import com.likebookapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PostController {


    private final PostService postService;
    private final LoggedUser loggedUser;

    public PostController(PostService postService, LoggedUser loggedUser) {
        this.postService = postService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/posts/add")
    public ModelAndView add(@ModelAttribute("postAddBindingModel") PostAddBindingModel postAddBindingModel) {

        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/users/login");
        }

        return new ModelAndView("post-add");
    }

    @PostMapping("/posts/add")
    public ModelAndView add(@ModelAttribute("postAddBindingModel") @Valid PostAddBindingModel postAddBindingModel,
                            BindingResult bindingResult) {

        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/users/login");
        }

        if (bindingResult.hasErrors()) {

            return new ModelAndView("post-add");
        }

        postService.addPost(postAddBindingModel);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/posts/remove/{id}")
    public ModelAndView removeTask(@PathVariable("id") Long id) {

        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        postService.remove(id);

        return new ModelAndView("redirect:/home");
    }
    @GetMapping("/posts/like-post/{id}")
    public ModelAndView likePost(@PathVariable("id") Long id) {

        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        postService.likePostWithId(id, loggedUser.getId());

        return new ModelAndView("redirect:/home");
    }
}
