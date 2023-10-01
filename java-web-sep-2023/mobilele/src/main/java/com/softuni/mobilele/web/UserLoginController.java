package com.softuni.mobilele.web;

import com.softuni.mobilele.model.dto.UserLoginDTO;
import com.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserLoginController {


    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO) {

        boolean loginSuccessful = userService.loginUser(userLoginDTO);

        return loginSuccessful ? "index" : "auth-login";
    }

    @GetMapping("/logout")
    public String logout() {

        userService.logoutUser();

        return "index";
    }
}
