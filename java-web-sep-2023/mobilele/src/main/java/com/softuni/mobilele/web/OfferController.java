package com.softuni.mobilele.web;

import com.softuni.mobilele.model.dto.AddOfferDTO;
import com.softuni.mobilele.model.dto.CreateOfferDTO;
import com.softuni.mobilele.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/all")
    public String all() {
        return "/offers";
    }

    @GetMapping("/add")
    public String add(Model model) {
        if(!model.containsAttribute("addOfferModel")) {
            model.addAttribute("addOfferModel", new AddOfferDTO());
        }
        model.addAttribute("brands", offerService.getAllBrands());
        return "offer-add";
    }

    @PostMapping("/add")
    public String add(@Valid AddOfferDTO addOfferModel,
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

    @GetMapping("/{uuid}/details")
    public String details(@PathVariable("uuid") UUID uuid) {
        return "details";
    }


}
