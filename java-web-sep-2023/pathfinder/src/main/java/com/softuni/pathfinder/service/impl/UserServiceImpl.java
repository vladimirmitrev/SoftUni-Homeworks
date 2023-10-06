package com.softuni.pathfinder.service.impl;

import com.softuni.pathfinder.model.entity.UserEntity;
import com.softuni.pathfinder.model.entity.enums.LevelEnum;
import com.softuni.pathfinder.model.service.UserServiceModel;
import com.softuni.pathfinder.repository.UserRepository;
import com.softuni.pathfinder.service.UserService;
import com.softuni.pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        user.setLevel(LevelEnum.BEGINNER);

        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {

        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }

    @Override
    public UserServiceModel findUserById(Long id) {
        return userRepository
                .findById(id)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public boolean findByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .isPresent();
    }

    @Override
    public UserEntity findCurrentLoginUserEntity() {
        return userRepository
                .findById(currentUser.getId())
                .orElse(null);
    }
}
