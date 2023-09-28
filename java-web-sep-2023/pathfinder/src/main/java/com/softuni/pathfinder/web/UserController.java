package com.softuni.pathfinder.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/register")
    public String regiter() {

        return "register";
    }

    @PostMapping("/register")
    public String confirmRegister() {

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }
}
