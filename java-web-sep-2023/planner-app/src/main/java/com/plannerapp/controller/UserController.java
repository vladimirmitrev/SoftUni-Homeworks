package com.plannerapp.controller;

import com.plannerapp.model.dto.user.UserLoginBindingModel;
import com.plannerapp.model.dto.user.UserRegisterBindingModel;
import com.plannerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @ModelAttribute("userRegisterBindingModel")
//    public UserRegisterBindingModel initUserModel() {
//        return new UserRegisterBindingModel();
//    }


    @GetMapping("/login")
    public ModelAndView login(
            @ModelAttribute("userLoginBindingModel") UserLoginBindingModel userLoginBindingModel) {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(
            @ModelAttribute("userLoginBindingModel") @Valid UserLoginBindingModel userLoginBindingModel,
                              BindingResult bindingResult) {

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
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel") @Valid UserRegisterBindingModel userRegisterBindingModel,
                                        BindingResult bindingResult) {

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


        this.userService.logout();
        return new ModelAndView("redirect:/");
    }
}
