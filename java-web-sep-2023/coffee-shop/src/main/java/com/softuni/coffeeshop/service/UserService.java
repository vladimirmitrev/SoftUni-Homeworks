package com.softuni.coffeeshop.service;

import com.softuni.coffeeshop.model.binding.UserRegisterBindingModel;
import com.softuni.coffeeshop.model.entity.User;
import com.softuni.coffeeshop.model.service.UserServiceModel;
import com.softuni.coffeeshop.model.view.UserViewModel;

import java.util.List;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findUserById(Long id);

    List<UserViewModel> findAllUsersAndCountOrOrdersOrderByCountDesc();
}
