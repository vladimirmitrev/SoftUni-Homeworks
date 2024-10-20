package com.softuni.mobilele.web;

import com.softuni.mobilele.model.dto.user.UserRegistrationDTO;
import com.softuni.mobilele.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    private final UserService userService;
    private final LocaleResolver localeResolver;

    public UserRegistrationController(UserService userService, LocaleResolver localeResolver) {
        this.userService = userService;
        this.localeResolver = localeResolver;
    }

//    @ModelAttribute("userModel")
//    public void initUserModel(Model model) {
//        model.addAttribute("userModel", new UserRegistrationDTO());
//    }
    @ModelAttribute("userModel")
    public UserRegistrationDTO initUserModel() {
        return new UserRegistrationDTO();
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDTO userModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userModel", userModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userModel",
                            bindingResult);

            return "redirect:/users/register";
        }

        this.userService.registerUser(userModel,
                localeResolver.resolveLocale(request));

        return "redirect:/";
    }
}
