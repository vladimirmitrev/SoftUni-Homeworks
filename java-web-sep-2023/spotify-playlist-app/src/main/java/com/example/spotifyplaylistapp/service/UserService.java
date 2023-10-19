package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dto.UserLoginBindingModel;
import com.example.spotifyplaylistapp.model.dto.UserRegisterBindingModel;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.util.LoggedUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
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

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
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
}
