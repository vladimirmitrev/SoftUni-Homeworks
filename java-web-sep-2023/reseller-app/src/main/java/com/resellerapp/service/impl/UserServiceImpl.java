package com.resellerapp.service.impl;

import com.resellerapp.model.entity.UserEntity;
import com.resellerapp.model.service.UserServiceModel;
import com.resellerapp.model.view.OfferBoughtViewModel;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.UserService;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public boolean findByUsernameOrEmail(String username, String email) {

        return userRepository
                .findByUsernameOrPassword(username, email)
                .isPresent();
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
//        user.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));

        userRepository.save(user);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
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
    public Optional<UserEntity> findById(Long id) {
        return userRepository
                .findById(id);
    }

    @Override
    public Optional<UserEntity> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

//    @Override
//    public UserEntity findByUsername(String username) {
//        return userRepository
//                .findByUsername(username)
//                .orElse(null);
//    }


}
