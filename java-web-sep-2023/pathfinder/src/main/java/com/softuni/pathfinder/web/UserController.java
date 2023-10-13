package com.softuni.pathfinder.web;


import com.softuni.pathfinder.model.binding.UserLoginBindingModel;
import com.softuni.pathfinder.model.binding.UserRegisterBindingModel;
import com.softuni.pathfinder.model.entity.UserEntity;
import com.softuni.pathfinder.model.service.UserServiceModel;
import com.softuni.pathfinder.model.view.UserViewModel;
import com.softuni.pathfinder.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @GetMapping("/register")
    public String register(Model model) {

        return "register";
    }

    @PostMapping("/register")
    public String confirmRegister(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userRegisterBindingModel
                .getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {

            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute(
                            "org.springframework.validation.BindingResult.userRegisterBindingModel",
                            bindingResult);

            return "redirect:register";
        }

        boolean isUsernameExists = userService
                .findByUsername(userRegisterBindingModel.getUsername());

        if(isUsernameExists) {
            //Todo: redirect with message
            return "redirect:register";
        }

        userService.registerUser(modelMapper
                .map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model) {

//        model.addAttribute("isExists", true);

        return "login";
    }

//    @PostMapping("/login")
//    public String confirmLogin(@Valid UserLoginBindingModel userLoginBindingModel,
//                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//
//        if (bindingResult.hasErrors()) {
//
//            redirectAttributes
//                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
//                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
//                            bindingResult);
//
//            return "redirect:login";
//        }
//
//        UserServiceModel user = userService
//                .findUserByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());
//
//        if (user == null) {
//            redirectAttributes
//                    .addFlashAttribute("isExist", false)
//                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
//                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
//                            bindingResult);
//
//            return "redirect:login";
//        }
//
//        userService.loginUser(user.getId(), user.getUsername());
//
//        return "redirect:/";
//    }

    @GetMapping("/logout")
    public String logout() {

//        userService.logout();

        return "redirect:/";
    }


    @GetMapping("/profile/")
    public String profile(Principal principal, Model model) {
        String username = principal.getName();

        UserEntity user = userService.getUser(username);

        UserViewModel userViewModel = new UserViewModel(
                username,
                user.getEmail(),
                user.getFullName(),
                user.getAge(),
                user.getLevel() != null ? user.getLevel().name() : "BEGINNER"
        );

        model.addAttribute("user", userViewModel);

        return "profile";
    }
}
