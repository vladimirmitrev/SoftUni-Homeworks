package com.resellerapp.web;

import com.resellerapp.model.binding.OfferAddBindingModel;
import com.resellerapp.model.service.OfferServiceModel;
import com.resellerapp.service.OfferService;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OfferController {


    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final OfferService offerService;

    public OfferController(CurrentUser currentUser, ModelMapper modelMapper, OfferService offerService) {
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.offerService = offerService;
    }

    @ModelAttribute("offerAddBindingModel")
    public OfferAddBindingModel initOrderModel() {
        return new OfferAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {

        if(currentUser.getId() == null) {
            return "redirect:/";
        }


        return "offer-add";
    }

    @PostMapping("/add")
    public String confirmAddOrder(@Valid OfferAddBindingModel offerAddBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes)  {

        if(bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("offerAddBindingModel", offerAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel",
                    bindingResult);

            return "redirect:add";
        }

        offerService.addOffer(modelMapper
                .map(offerAddBindingModel, OfferServiceModel.class));

        return "redirect:/home";
    }

    @GetMapping("/remove/{id}")
    String removePost(@PathVariable Long id) {

        offerService.removeOfferById(id);

        return "redirect:/home";
    }

    @GetMapping("buy-item/{id}")
    String buyItem(@PathVariable Long id) {

        offerService.buyItemWithId(id, currentUser.getId());

        return "redirect:/home";
    }
}
