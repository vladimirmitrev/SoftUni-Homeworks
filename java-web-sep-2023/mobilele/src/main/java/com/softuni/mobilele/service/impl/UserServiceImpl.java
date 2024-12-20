package com.softuni.mobilele.service.impl;

import com.softuni.mobilele.model.dto.user.UserRegistrationDTO;
import com.softuni.mobilele.model.entity.UserEntity;
import com.softuni.mobilele.model.mapper.UserMapper;
import com.softuni.mobilele.repository.UserRepository;
import com.softuni.mobilele.service.EmailService;
import com.softuni.mobilele.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserDetailsService userDetailsService;
    private final EmailService emailService;


    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           UserMapper userMapper,
                           UserDetailsService userDetailsService,
                           EmailService emailService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.userDetailsService = userDetailsService;
        this.emailService = emailService;
    }

    @Override
    public void createUserIfNotExist(String email) {
        Optional<UserEntity> optionalUser = this.userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            UserEntity newUser =
                    new UserEntity()
                            .setEmail(email)
                            .setPassword(null)
                            .setFirstName("New")
                            .setLastName("User")
                            .setUserRoles(List.of());

            userRepository.save(newUser);
        }

    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO,
                             Locale prefferedLocale) {

        UserEntity newUser = userMapper.userDtoToUserEntity(userRegistrationDTO);
        newUser.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));

        this.userRepository.save(newUser);
        login(newUser.getEmail());
        emailService.sendRegistrationEmail(newUser.getEmail(),
                newUser.getFirstName() + " " + newUser.getLastName(),
                prefferedLocale);

    }

    @Override
    public void login(String userName) {

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(userName);

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );

        SecurityContextHolder.
                getContext().
                setAuthentication(auth);
    }


}
