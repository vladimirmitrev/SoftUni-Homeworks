package com.example.shoppinglistapp.web;

import com.example.shoppinglistapp.model.dto.ProductViewBindingModel;
import com.example.shoppinglistapp.model.entity.enums.CategoryNameEnum;
import com.example.shoppinglistapp.service.ProductService;
import com.example.shoppinglistapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final ProductService productService;

    public HomeController(LoggedUser loggedUser, ProductService productService) {
        this.loggedUser = loggedUser;
        this.productService = productService;
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


        List<ProductViewBindingModel> foods = productService.getAllFoods(CategoryNameEnum.FOOD);
        model.addAttribute("foods", foods);
        List<ProductViewBindingModel> drinks = productService.getAllDrinks(CategoryNameEnum.DRINK);
        model.addAttribute("drinks", drinks);
        List<ProductViewBindingModel> houseHolds = productService.getAllHouseholds(CategoryNameEnum.HOUSEHOLD);
        model.addAttribute("houseHolds", houseHolds);
        List<ProductViewBindingModel> others = productService.getAllOthers(CategoryNameEnum.OTHER);
        model.addAttribute("others", others);

        List<ProductViewBindingModel> allProducts = productService.getAllProducts();
        BigDecimal totalPrice = allProducts.stream()
                .map(ProductViewBindingModel::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        model.addAttribute("totalPrice", totalPrice);


        return "home";
    }
}
