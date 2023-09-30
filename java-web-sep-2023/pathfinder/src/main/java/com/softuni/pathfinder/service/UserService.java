package com.softuni.pathfinder.service;

import com.softuni.pathfinder.model.service.UserServiceModel;

public interface UserService {


    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logout();


    UserServiceModel findUserById(Long id);
}
