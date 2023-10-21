package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.word.WordViewBindingModel;
import com.dictionaryapp.model.entity.enums.LanguageNameEnum;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final WordService wordService;

    public HomeController(LoggedUser loggedUser, WordService wordService) {
        this.loggedUser = loggedUser;
        this.wordService = wordService;
    }

    @GetMapping("/")
    public String index() {

        if (loggedUser.isLogged()) {
            return ("redirect:/home");
        }

        return ("index");
    }

    @GetMapping("/home")
    public String home(Model model) {

        if (!loggedUser.isLogged()) {
            return "redirect:/";
        }


        List<WordViewBindingModel> allWords = wordService.findAllWords();
        Integer totalWords = allWords.size();
        model.addAttribute("totalWordsCount", totalWords);

        List<WordViewBindingModel> germanPosts = this.wordService.getGermanPost(LanguageNameEnum.GERMAN);
        model.addAttribute("germanPosts", germanPosts);

        List<WordViewBindingModel> italianPost = this.wordService.getItalianPost(LanguageNameEnum.ITALIAN);
        model.addAttribute("italianPost", italianPost);

        List<WordViewBindingModel> spanishPost = this.wordService.getSpanishPost(LanguageNameEnum.SPANISH);
        model.addAttribute("spanishPost", spanishPost);

        List<WordViewBindingModel> frenchPost = this.wordService.getFrenchPost(LanguageNameEnum.FRENCH);
        model.addAttribute("frenchPost", frenchPost);

        return "home";
    }
}
