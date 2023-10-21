package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.user.UserLoginBindingModel;
import com.dictionaryapp.model.dto.user.UserRegisterBindingModel;

public interface UserService {
    void registerUser(UserRegisterBindingModel userRegisterBindingModel);

    boolean findByUsernameOrEmail(String username, String email);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
