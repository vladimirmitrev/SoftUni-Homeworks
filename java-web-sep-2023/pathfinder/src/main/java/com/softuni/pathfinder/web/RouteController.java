package com.softuni.pathfinder.web;

import com.softuni.pathfinder.model.binding.RouteAddBindingModel;
import com.softuni.pathfinder.model.service.RouteServiceModel;
import com.softuni.pathfinder.model.view.RouteDetailsViewModel;
import com.softuni.pathfinder.model.view.RouteViewModel;
import com.softuni.pathfinder.service.RouteService;
import com.softuni.pathfinder.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;
import java.security.PublicKey;
import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public RouteController(RouteService routeService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public RouteAddBindingModel routeAddBindingModel() {
        return new RouteAddBindingModel();
    }

    @GetMapping("/all")
    public String allRoutes(Model model) {

        List<RouteViewModel> routes = routeService.findAllRoutesView();

        model.addAttribute("routes", routes);

        return "routes";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {

        RouteDetailsViewModel route = routeService.findRouteById(id);

        model.addAttribute("route", route);

        return "route-details";
    }


    @GetMapping("/add")
    public String add(Principal principal) {

//        if (currentUser.getId() == null) {
//            return "redirect:/users/login";
//        }

        return "add-route";
    }

    @PostMapping("/add")
    public String confirmAdd(@Valid RouteAddBindingModel routeAddBindingModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             @AuthenticationPrincipal UserDetails userDetails) throws IOException {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("routeAddBindingModel", routeAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.routeAddBindingModel",
                    bindingResult);

            return "redirect:add";
        }

        RouteServiceModel routeServiceModel = modelMapper
                .map(routeAddBindingModel, RouteServiceModel.class);
        routeServiceModel.setGpxCoordinates(new String(
                routeAddBindingModel.getGpxCoordinates().getBytes()));


        routeService.addNewRoute(routeServiceModel, userDetails);


        return "redirect:all";
    }
}
