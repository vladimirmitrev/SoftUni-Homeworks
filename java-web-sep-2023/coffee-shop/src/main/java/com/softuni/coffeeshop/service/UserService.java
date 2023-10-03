package com.softuni.coffeeshop.service;

import com.softuni.coffeeshop.model.binding.UserRegisterBindingModel;
import com.softuni.coffeeshop.model.service.UserServiceModel;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

}
