package com.example.shoppinglistapp.service;

import com.example.shoppinglistapp.model.dto.UserLoginBindingModel;
import com.example.shoppinglistapp.model.dto.UserRegisterBindingModel;
import com.example.shoppinglistapp.model.entity.User;
import com.example.shoppinglistapp.repository.UserRepository;
import com.example.shoppinglistapp.util.LoggedUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    public boolean findByUsernameOrEmail(String username, String email) {

        return userRepository
                .findByUsernameOrEmail(username,email)
                .isPresent();
    }

    public void registerUser(UserRegisterBindingModel userRegisterBindingModel) {

        User user = new User();
        user.setUsername(userRegisterBindingModel.getUsername());
        user.setEmail(userRegisterBindingModel.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));

        userRepository.save(user);
    }

    public boolean login(UserLoginBindingModel userLoginBindingModel) {

        String username = userLoginBindingModel.getUsername();

        User user = userRepository
                .findByUsername(userLoginBindingModel.getUsername())
                .orElse(null);

        if(user != null
                && passwordEncoder.matches(userLoginBindingModel.getPassword(),user.getPassword())) {

            loggedUser.setId(user.getId());
            loggedUser.setUsername(user.getUsername());
            loggedUser.login(username);

            return true;
        }
        return false;
    }
    public void logout() {
        this.loggedUser.logout();
    }
}
