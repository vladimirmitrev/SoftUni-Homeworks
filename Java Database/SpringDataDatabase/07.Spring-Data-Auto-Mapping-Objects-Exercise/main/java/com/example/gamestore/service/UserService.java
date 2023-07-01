package com.example.gamestore.service;

import com.example.gamestore.model.dto.UserLoginDto;
import com.example.gamestore.model.dto.UserRegisterDto;

public interface UserService{
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();
}
