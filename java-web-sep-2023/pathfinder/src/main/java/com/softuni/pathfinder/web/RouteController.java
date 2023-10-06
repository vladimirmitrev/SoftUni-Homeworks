package com.softuni.pathfinder.web;

import com.softuni.pathfinder.service.RouteService;
import com.softuni.pathfinder.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final CurrentUser currentUser;

    public RouteController(RouteService routeService, CurrentUser currentUser) {
        this.routeService = routeService;
        this.currentUser = currentUser;
    }

    @GetMapping("/all")
    public String allRoutes(Model model) {

        model.addAttribute("routes", routeService.findAllRoutesView());

        return "routes";
    }

    @GetMapping("/add")
    public String add() {

        if(currentUser.getId() == null) {
            return "redirect:/users/login";
        }

        return "add-route";
    }
}
