package com.softuni.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginControler {

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }
}
