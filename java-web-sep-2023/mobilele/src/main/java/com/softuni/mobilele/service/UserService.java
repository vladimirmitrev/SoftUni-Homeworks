package com.softuni.mobilele.service;

import com.softuni.mobilele.model.dto.user.UserRegistrationDTO;
import com.softuni.mobilele.model.entity.UserEntity;

import java.util.Locale;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegistrationDTO, Locale prefferedLocale);

    void login(String userName);

}
