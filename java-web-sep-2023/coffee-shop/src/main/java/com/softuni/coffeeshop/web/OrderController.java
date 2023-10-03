package com.softuni.coffeeshop.web;

import com.softuni.coffeeshop.model.binding.OrderAddBindingModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
public class OrderController {


    @ModelAttribute("orderAddBindingModel")
    public OrderAddBindingModel initOrderModel() {
        return new OrderAddBindingModel();
    }


    @GetMapping("/add")
    public String add() {


        return "order-add";
    }

    @PostMapping("/add")
    public String confirmAddOrder(@Valid OrderAddBindingModel orderAddBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes)  {

        if(bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("orderAddBindingModel", orderAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel",
                    bindingResult);

            return "redirect:add";
        }


        return "redirect:/";
    }

}
