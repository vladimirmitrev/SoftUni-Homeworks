package com.softuni.mobilele.web;

import com.softuni.mobilele.model.dto.offer.AddOfferDTO;
import com.softuni.mobilele.model.dto.offer.SearchOfferDTO;
import com.softuni.mobilele.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
//@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers/all")
    public String allOffers() {
        return "offers";
    }

    @GetMapping("/offers/add")
    public String add(Model model) {
        if(!model.containsAttribute("addOfferModel")) {
            model.addAttribute("addOfferModel", new AddOfferDTO());
        }
        model.addAttribute("brands", offerService.getAllBrands());
        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String addOffer(@Valid AddOfferDTO addOfferModel,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("addOfferModel", addOfferModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel",
                            bindingResult);

            return "redirect:/offers/add";
        }

        offerService.addOffer(addOfferModel);

        return "redirect:/offers/all";
    }

//    @GetMapping("/{uuid}/details")
//    public String details(@PathVariable("uuid") UUID uuid) {
//        return "details";
//    }

    @GetMapping("/offers/search")
    public String searchOffer() {
        return "offer-search";
    }
    @PostMapping("/offers/search")
    public String searchQuery(@Valid SearchOfferDTO searchOfferDTO,
                              BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("searchOfferModel", searchOfferDTO);
            model.addAttribute(
                    "org.springframework.validation.BindingResult.searchOfferModel",
                    bindingResult);

            return "redirect:/offers/search";
        }

//        if (!model.containsAttribute("searchOfferModel")) {
//            model.addAttribute("searchOfferModel", searchOfferDTO);
//        }

//        if (!searchOfferDTO.isEmpty()) {
//            model.addAttribute("offers", offerService.searchOffer(searchOfferDTO));
//        }

        return String.format("redirect:/offers/search/%s", searchOfferDTO.getQuery());
    }

    @GetMapping("offers/search/{query}")
    public String searchResults(@PathVariable String query, Model model) {
        model.addAttribute("offers", this.offerService.findOfferByOfferName(query));
        return "offer-search";
    }

    @ModelAttribute(name = "searchOfferModel")
    private SearchOfferDTO initSearchModel() {
        return new SearchOfferDTO();
    }

}
