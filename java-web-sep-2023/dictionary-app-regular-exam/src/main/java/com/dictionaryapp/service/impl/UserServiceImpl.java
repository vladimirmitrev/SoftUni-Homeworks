package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.user.UserLoginBindingModel;
import com.dictionaryapp.model.dto.user.UserRegisterBindingModel;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.util.LoggedUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean findByUsernameOrEmail(String username, String email) {

        return userRepository
                .findByUsernameOrEmail(username, email)
                .isPresent();
    }

    @Override
    public void registerUser(UserRegisterBindingModel userRegisterBindingModel) {

        User user = new User();
        user.setUsername(userRegisterBindingModel.getUsername());
        user.setEmail(userRegisterBindingModel.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));

        userRepository.save(user);
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {

        String username = userLoginBindingModel.getUsername();

        User user = userRepository
                .findByUsername(userLoginBindingModel.getUsername())
                .orElse(null);

        if (user != null
                && passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword())) {

            loggedUser.setId(user.getId());
            loggedUser.setUsername(user.getUsername());
            loggedUser.login(username);

            return true;
        }
        return false;
    }

    @Override
    public void logout() {
        this.loggedUser.logout();
    }
}
