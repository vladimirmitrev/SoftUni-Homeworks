package com.example.shoppinglistapp.web;

import com.example.shoppinglistapp.model.dto.ProductAddBindingModel;
import com.example.shoppinglistapp.service.ProductService;
import com.example.shoppinglistapp.service.UserService;
import com.example.shoppinglistapp.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final UserService userService;
    private final ProductService productService;
    private final LoggedUser loggedUser;

    public ProductController(UserService userService, ProductService productService, LoggedUser loggedUser) {
        this.userService = userService;
        this.productService = productService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute("productAddBindingModel")
    public ProductAddBindingModel initSongModel() {
        return new ProductAddBindingModel();
    }

    @GetMapping("/add")
    public String add() {

//        if(!loggedUser.isLogged()) {
//            return "redirect:/users/login";
//        }


        return "product-add";
    }
    @PostMapping("/add")
    public String confirmAdd(@Valid ProductAddBindingModel productAddBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes)  {

//        if(!loggedUser.isLogged()) {
//            return "redirect:/users/login";
//        }

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
}
