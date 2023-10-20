package com.example.shoppinglistapp.web;

import com.example.shoppinglistapp.model.dto.ProductAddBindingModel;
import com.example.shoppinglistapp.service.ProductService;
import com.example.shoppinglistapp.service.UserService;
import com.example.shoppinglistapp.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final LoggedUser loggedUser;

    public ProductController(ProductService productService, LoggedUser loggedUser) {
        this.productService = productService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("productAddBindingModel")
    public ProductAddBindingModel initSongModel() {
        return new ProductAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {

        if(!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }


        return "product-add";
    }
    @PostMapping("/add")
    public String confirmAdd(@Valid ProductAddBindingModel productAddBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes)  {

        if(!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        if(bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel",
                    bindingResult);

            return "redirect:add";
        }

        productService.addProduct(productAddBindingModel);

        return "redirect:/home";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable Long id) {

        if(!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        productService.removeProductById(id);

        return "redirect:/home";
    }
    @GetMapping("/buy-all")
    public String buyAll() {

        if(!loggedUser.isLogged()) {
            return "redirect:/users/login";
        }

        productService.removeAllProducts();

        return "redirect:/home";
    }
}
