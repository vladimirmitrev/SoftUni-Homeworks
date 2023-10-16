package com.resellerapp.web;

import com.resellerapp.model.entity.OfferEntity;
import com.resellerapp.model.entity.UserEntity;
import com.resellerapp.model.view.OfferBoughtViewModel;
import com.resellerapp.model.view.OfferViewModel;
import com.resellerapp.model.view.OfferViewOthersModel;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;
import com.resellerapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final OfferService offerService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, OfferService offerService, UserService userSerice) {
        this.currentUser = currentUser;
        this.offerService = offerService;
        this.userService = userSerice;
    }

    @GetMapping("/home")
    public String home(Model model) {

        if(currentUser.getId() == null) {
            return "redirect:/";
        }

        UserEntity user = userService
                .findById(currentUser.getId())
                .orElse(null);
        model.addAttribute("currentUserInfo", user);

        List<OfferViewModel> myOffers = offerService.findMyOffers(currentUser.getId());
        model.addAttribute("myOffers", myOffers);

        List<OfferViewOthersModel> allOtherOffers = offerService.findAllOtherOffers(currentUser.getId());
        model.addAttribute("otherOffers", allOtherOffers);

        List<OfferEntity> boughtOffers = offerService.getAllBoughtOffers(currentUser.getId());
        model.addAttribute("boughtOffers", boughtOffers);


        return "home";
    }

//    @GetMapping("/index")
//    public String index(Model model) {
//
//
//        return "index";
//    }
}
