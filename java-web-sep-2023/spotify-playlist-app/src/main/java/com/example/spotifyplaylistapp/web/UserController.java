package com.example.spotifyplaylistapp.web;

import com.example.spotifyplaylistapp.model.dto.user.UserLoginBindingModel;
import com.example.spotifyplaylistapp.model.dto.user.UserRegisterBindingModel;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final LoggedUser loggedUser;
    private final UserService userService;

    public UserController(LoggedUser loggedUser, UserService userService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    @ModelAttribute("userRegisterBindingModel")
    public UserRegisterBindingModel initUserModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute("userLoginBindingModel")
    public UserLoginBindingModel loginUserModel() {
        return new UserLoginBindingModel();
    }

    @GetMapping("/register")
    public String register(Model model) {

        if (loggedUser.isLogged()) {
            return "redirect:/home";
        }

        if (!model.containsAttribute("notTaken")) {
            model.addAttribute("notTaken", true);
        }

        return "register";
    }

    @PostMapping("/register")
    public String confirmRegister(Model model, @Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (loggedUser.isLogged()) {
            return "redirect:/home";
        }


        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {

            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                            bindingResult);

            return "redirect:register";
        }


        boolean isUsernameOrEmailExits = userService
                .findByUsernameOrEmail(userRegisterBindingModel.getUsername(),
                        userRegisterBindingModel.getEmail());

        if (isUsernameOrEmailExits) {
            redirectAttributes.addFlashAttribute("notTaken", false);
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);

            return "redirect:register";
        }

        userService.registerUser(userRegisterBindingModel);


        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model) {

        if (loggedUser.isLogged()) {
            return "redirect:/home";
        }

        if (!model.containsAttribute("isFound")) {
            model.addAttribute("isFound", true);
        }

        return "login";
    }

    @PostMapping("/login")
    public String confirmLogin(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (loggedUser.isLogged()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);

            return "redirect:login";
        }

        boolean successfulLogin = userService.login(userLoginBindingModel);

        if (!successfulLogin) {
            redirectAttributes
                    .addFlashAttribute("isFound", false)
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel);

            return "redirect:login";
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {

        if (!loggedUser.isLogged()) {
            return "redirect:/";
        }

        userService.logout();

//        httpSession.invalidate();

        return "redirect:/";
    }

}
