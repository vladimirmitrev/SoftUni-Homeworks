package com.softuni.mobilele.service;

import com.softuni.mobilele.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public void registerUser(UserRegisterDTO userRegisterDTO) {
//        userRepository.save(map(userRegisterDTO));
//    }

//    private UserEntity map(UserRegisterDTO userRegisterDTO) {
//        return new UserEntity()
//                .setActive(true);
//    }
}
