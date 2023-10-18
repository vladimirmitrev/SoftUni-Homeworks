package com.likebookapp.web;

import com.likebookapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;

    public HomeController(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    public ModelAndView index() {

//        if(loggedUser.isLogged()) {
//            return new ModelAndView("redirect:/home");
//        }

        return new ModelAndView("index");
    }

//    @GetMapping("/home")
//    public ModelAndView home(@ModelAttribute("taskHomeViewModel") TaskHomeViewModel taskHomeViewModel) {
//
//        if(!loggedUser.isLogged()) {
//            return new ModelAndView("redirect:/");
//        }
//
//        TaskHomeViewModel viewModel = taskService.getHomeViewData(loggedUser.getUsername());
//
//        return new ModelAndView("home", "tasks", viewModel);
//    }
    @GetMapping("/home")
    public ModelAndView home() {

//        if(!loggedUser.isLogged()) {
//            return new ModelAndView("redirect:/");
//        }


        return new ModelAndView("home");
    }

}
