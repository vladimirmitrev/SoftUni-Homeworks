package com.resellerapp.service;

import com.resellerapp.model.entity.UserEntity;
import com.resellerapp.model.service.UserServiceModel;
import com.resellerapp.model.view.OfferBoughtViewModel;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean findByUsernameOrEmail(String username, String email);

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    Optional<UserEntity> findById(Long id);

    Optional<UserEntity> findUserById(Long userId);

//    UserEntity findByUsername(String username);
}
