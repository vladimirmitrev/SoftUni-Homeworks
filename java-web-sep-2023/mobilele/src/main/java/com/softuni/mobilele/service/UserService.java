package com.softuni.mobilele.service;

import com.softuni.mobilele.model.dto.user.UserRegistrationDTO;
import com.softuni.mobilele.model.entity.UserEntity;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegistrationDTO);

    void loginUser(UserEntity userEntity);

}
