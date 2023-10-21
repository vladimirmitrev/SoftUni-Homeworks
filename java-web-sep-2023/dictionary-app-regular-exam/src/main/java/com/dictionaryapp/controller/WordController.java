package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.word.WordAddBindingModel;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/words")
public class WordController {

    private final WordService wordService;
    private final UserService userService;
    private final LoggedUser loggedUser;

    public WordController(WordService wordService, UserService userService, LoggedUser loggedUser) {
        this.wordService = wordService;
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("wordAddBindingModel")
    public WordAddBindingModel initWordModel() {
        return new WordAddBindingModel();
    }

    @GetMapping("/add")
    public String addWord() {

        if(!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }


        return "word-add";
    }
    @PostMapping("/add")
    public String confirmAddWord(@Valid WordAddBindingModel wordAddBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes)  {

        if(!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        if(bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("wordAddBindingModel", wordAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.wordAddBindingModel",
                    bindingResult);

            return "redirect:/words/add";
        }

        wordService.addWord(wordAddBindingModel);

        return "redirect:/home";
    }

    @GetMapping("/remove/{id}")
    public String removeWord(@PathVariable Long id) {

        if(!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        wordService.removeById(id);

        return "redirect:/home";
    }


    @GetMapping("/remove-all")
    public String removeAllWords() {

        if(!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        wordService.removeAllWords();

        return "redirect:/home";
    }
}
