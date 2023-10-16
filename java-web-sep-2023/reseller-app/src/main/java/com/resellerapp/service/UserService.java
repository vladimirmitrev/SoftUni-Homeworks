package com.resellerapp.service;

import com.resellerapp.model.service.UserServiceModel;

public interface UserService {

    boolean findByUsernameOrEmail(String username, String email);

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);
}
