package com.likebookapp.service;

import com.likebookapp.model.dto.user.UserLoginBindingModel;
import com.likebookapp.model.dto.user.UserRegisterBindingModel;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.util.LoggedUser;
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


    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {

        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            return false;
        }

        boolean existByUsernameOrEmail = userRepository.existsByUsernameOrEmail(
                userRegisterBindingModel.getUsername(),
                userRegisterBindingModel.getEmail());

        if (existByUsernameOrEmail) {
            return false;
        }

        User user = new User();
        user.setUsername(userRegisterBindingModel.getUsername());
        user.setEmail(userRegisterBindingModel.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));

        userRepository.save(user);

        return true;
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

    public Optional<User> findUserById(Long id) {

        return userRepository
                .findById(id);
    }

    public User findByUsername(String username) {

        return userRepository
                .findByUsername(username)
                .orElse(null);
    }

    public User findById(Long userId) {

        return userRepository
                .findById(userId)
                .orElse(null);
    }
}
