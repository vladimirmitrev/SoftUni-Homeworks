package com.softuni.pathfinder.service;

import com.softuni.pathfinder.model.view.RouteViewModel;

import java.util.List;

public interface RouteService {
    List<RouteViewModel> findAllRoutesView();
}
