package com.softuni.coffeeshop.service.impl;

import com.softuni.coffeeshop.model.entity.Order;
import com.softuni.coffeeshop.model.service.OrderServiceModel;
import com.softuni.coffeeshop.repository.OrderRepository;
import com.softuni.coffeeshop.service.CategoryService;
import com.softuni.coffeeshop.service.OrderService;
import com.softuni.coffeeshop.service.UserService;
import com.softuni.coffeeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {

        Order order = modelMapper.map(orderServiceModel, Order.class);

        order.setEmployee(userService.findUserById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));

        orderRepository.save(order);
    }
}
