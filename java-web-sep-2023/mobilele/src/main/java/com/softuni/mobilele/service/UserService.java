package com.softuni.mobilele.service;

import com.softuni.mobilele.model.dto.user.UserLoginDTO;
import com.softuni.mobilele.model.dto.user.UserRegistrationDTO;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegistrationDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    void logoutUser();
}
