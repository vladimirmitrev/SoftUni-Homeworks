package com.softuni.pathfinder.service.impl;

import com.softuni.pathfinder.model.entity.RouteEntity;
import com.softuni.pathfinder.model.entity.UserEntity;
import com.softuni.pathfinder.model.service.RouteServiceModel;
import com.softuni.pathfinder.model.view.RouteDetailsViewModel;
import com.softuni.pathfinder.model.view.RouteViewModel;
import com.softuni.pathfinder.repository.RouteRepository;
import com.softuni.pathfinder.repository.UserRepository;
import com.softuni.pathfinder.service.CategoryService;
import com.softuni.pathfinder.service.RouteService;
import com.softuni.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository,
                            UserRepository userRepository, UserService userService,
                            CategoryService categoryService, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.categoryService = categoryService;
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

        return routeViewModels;
    }

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel, UserDetails userDetails) {

        RouteEntity route = modelMapper.map(routeServiceModel, RouteEntity.class);

        UserEntity author = userRepository
                .findByUsername(userDetails.getUsername()).
                orElseThrow(() -> new UsernameNotFoundException("User not found!"));

        route.setAuthor(author);

        route.setCategories(routeServiceModel.getCategories()
                .stream()
                .map(categoryNameEnum -> categoryService.findByCategoryName(categoryNameEnum))
                .collect(Collectors.toSet()));


        routeRepository.save(route);
    }

    @Override
    public RouteDetailsViewModel findRouteById(Long id) {


        return routeRepository
                .findById(id)
                .map(routeEntity ->
                        modelMapper.map(routeEntity, RouteDetailsViewModel.class))
                .orElse(null);
    }
}
