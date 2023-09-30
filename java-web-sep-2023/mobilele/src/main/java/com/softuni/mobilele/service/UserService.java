package com.softuni.mobilele.service;

import com.softuni.mobilele.model.dto.UserLoginDTO;
import com.softuni.mobilele.model.dto.UserRegistrationDTO;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegistrationDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    void logoutUser();
}
