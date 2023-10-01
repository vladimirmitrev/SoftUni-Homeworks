package com.softuni.mobilele.service.impl;

import com.softuni.mobilele.model.dto.UserLoginDTO;
import com.softuni.mobilele.model.dto.UserRegistrationDTO;
import com.softuni.mobilele.model.entity.UserEntity;
import com.softuni.mobilele.model.mapper.UserMapper;
import com.softuni.mobilele.repository.UserRepository;
import com.softuni.mobilele.service.UserService;
import com.softuni.mobilele.util.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;
    private final UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           CurrentUser currentUser,
                           UserMapper userMapper) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
        this.userMapper = userMapper;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        userRepository.save(map(userRegistrationDTO));
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {

        var userEntity = userRepository
                .findByEmail(userLoginDTO.email())
                .orElse(null);

        boolean loginSuccess = false;

        if (userEntity != null) {
            String rawPassword = userLoginDTO.password();
            String encodedPassword = userEntity.getPassword();

            loginSuccess = encodedPassword != null &&
                    passwordEncoder.matches(rawPassword, encodedPassword);

            if (loginSuccess) {
                currentUser.setLogged(true);
                currentUser.setFirstName(userEntity.getFirstName());
                currentUser.setLastName(userEntity.getLastName());
                currentUser.setEmail(userEntity.getEmail());

            } else {
                currentUser.logout();
            }
        }
        return loginSuccess;
    }

    @Override
    public void logoutUser() {
        currentUser.logout();
    }

    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {

        UserEntity newUser = userMapper.userDtoToUserEntity(userRegistrationDTO);
        newUser.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));

        return newUser;
    }
}
