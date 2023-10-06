package com.softuni.pathfinder.service;

import com.softuni.pathfinder.model.service.RouteServiceModel;
import com.softuni.pathfinder.model.view.RouteDetailsViewModel;
import com.softuni.pathfinder.model.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutesView();

    void addNewRoute(RouteServiceModel routeServiceModel);


    RouteDetailsViewModel findRouteById(Long id);
}
