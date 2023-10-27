package com.softuni.mobilele.web;

import com.softuni.mobilele.model.dto.offer.AddOfferDTO;
import com.softuni.mobilele.model.dto.offer.SearchOfferDTO;
import com.softuni.mobilele.model.user.MobileleUserDetails;
import com.softuni.mobilele.service.OfferService;
import jakarta.validation.Valid;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    public String allOffers(
            @PageableDefault(
                    sort = "price",
                    direction = Sort.Direction.ASC,
                    page = 0,
                    size = 5) Pageable pageable,
            Model model
    ) {

        model.addAttribute("offers", offerService.getAllOffers(pageable));

        return "offers";
    }

    @GetMapping("/offers/add")
    public String add(Model model) {
        if (!model.containsAttribute("addOfferModel")) {
            model.addAttribute("addOfferModel", new AddOfferDTO());
        }
        model.addAttribute("brands", offerService.getAllBrands());
        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String addOffer(@Valid AddOfferDTO addOfferModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal MobileleUserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("addOfferModel", addOfferModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel",
                            bindingResult);

            return "redirect:/offers/add";
        }

        offerService.addOffer(addOfferModel, userDetails);

        return "redirect:/offers/all";
    }

//    @GetMapping("/{uuid}/details")
//    public String details(@PathVariable("uuid") UUID uuid) {
//        return "details";
//    }


    @GetMapping("/offers/search")
    public String searchQuery(@Valid SearchOfferDTO searchOfferDTO,
                              BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("searchOfferModel", searchOfferDTO);
            model.addAttribute(
                    "org.springframework.validation.BindingResult.searchOfferModel",
                    bindingResult);

            return "offer-search";
        }

        if (!model.containsAttribute("searchOfferModel")) {
            model.addAttribute("searchOfferModel", searchOfferDTO);
        }

        if (!searchOfferDTO.isEmpty()) {
            model.addAttribute("offers", offerService.searchOffer(searchOfferDTO));
        }

        return "offer-search";
    }
    @GetMapping("/offers/{id}")
    public String getOfferDetail(@PathVariable("id") UUID uuid,
                                 Model model) {

//        var offerDto =
//                offerService.findOfferByUUID(uuid).
//                        orElseThrow(() -> new ObjectNotFoundException("Offer with UUID " +
//                                uuid + " not found!"));

//        model.addAttribute("offer", offerDto);

        return "details";
    }
}
