package com.softuni.pathfinder.service.impl;

import com.softuni.pathfinder.model.view.RouteViewModel;
import com.softuni.pathfinder.repository.RouteRepository;
import com.softuni.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RouteViewModel> findAllRoutesView() {

        List<RouteViewModel> routeViewModels = routeRepository
                .findAll()
                .stream()
                .map(route -> {

                    RouteViewModel routeViewModel = modelMapper.map(route, RouteViewModel.class);

                    if (route.getPictures().isEmpty()) {
                        routeViewModel.setPictureUrl("/images/pic4.jpg");
                    } else {
                        routeViewModel.setPictureUrl(route.getPictures().stream().findAny().get().getUrl());
                    }

                    return routeViewModel;
                })
                .collect(Collectors.toList());

        return  routeViewModels;
    }
}
