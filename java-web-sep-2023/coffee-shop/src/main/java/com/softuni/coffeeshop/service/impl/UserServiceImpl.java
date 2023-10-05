package com.softuni.coffeeshop.service.impl;

import com.softuni.coffeeshop.model.entity.User;
import com.softuni.coffeeshop.model.service.UserServiceModel;
import com.softuni.coffeeshop.model.view.UserViewModel;
import com.softuni.coffeeshop.repository.UserRepository;
import com.softuni.coffeeshop.service.UserService;
import com.softuni.coffeeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {

        User user = modelMapper.map(userServiceModel, User.class);

        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
//              return userRepository.save(user);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public User findUserById(Long id) {


        return userRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public List<UserViewModel> findAllUsersAndCountOrOrdersOrderByCountDesc() {


        return userRepository.findAllUsersOrderedByOrdersCount()
                .stream()
                .map(user -> {
                    UserViewModel userViewModel = new UserViewModel();

                    userViewModel.setUsername(user.getUsername());
                    userViewModel.setCountOfOrders(user.getOrders().size());

                    return userViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public boolean findByUsername(String username) {

        return userRepository
                .findByUsername(username)
                .isPresent();
    }

    @Override
    public boolean findByEmail(String email) {

        return userRepository
                .findByEmail(email)
                .isPresent();
    }
}
