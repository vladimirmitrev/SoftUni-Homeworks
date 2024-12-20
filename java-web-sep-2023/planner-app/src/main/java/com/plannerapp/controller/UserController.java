package com.plannerapp.controller;

import com.plannerapp.model.dto.user.UserLoginBindingModel;
import com.plannerapp.model.dto.user.UserRegisterBindingModel;
import com.plannerapp.service.UserService;
import com.plannerapp.service.impl.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final LoggedUser loggedUser;

    public UserController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

//    @ModelAttribute("userRegisterBindingModel")
//    public UserRegisterBindingModel initUserModel() {
//        return new UserRegisterBindingModel();
//    }


    @GetMapping("/login")
    public ModelAndView login(
            @ModelAttribute("userLoginBindingModel") UserLoginBindingModel userLoginBindingModel) {

        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(
            @ModelAttribute("userLoginBindingModel") @Valid UserLoginBindingModel userLoginBindingModel,
                              BindingResult bindingResult) {

        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        if (bindingResult.hasErrors()) {

            return new ModelAndView("login");
        }

        boolean successfulLogin = userService.login(userLoginBindingModel);

        if(!successfulLogin) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("hasLoginError", true);
            return modelAndView;
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel) {

        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel") @Valid UserRegisterBindingModel userRegisterBindingModel,
                                        BindingResult bindingResult) {

        if(loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        if (bindingResult.hasErrors()) {

            return new ModelAndView("register");
        }

        boolean successfulRegister = userService.register(userRegisterBindingModel);

        if(!successfulRegister) {
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("hasRegisterError", true);
            return modelAndView;
         }

        return new ModelAndView("redirect:login");
    }

    @GetMapping("/logout")
    public ModelAndView logout() {

        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        this.userService.logout();
        return new ModelAndView("redirect:/");
    }
}
