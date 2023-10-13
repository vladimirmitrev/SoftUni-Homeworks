package com.softuni.pathfinder.service.impl;

import com.softuni.pathfinder.model.entity.RoleEntity;
import com.softuni.pathfinder.model.entity.UserEntity;
import com.softuni.pathfinder.model.user.PathfinderUserDetails;
import com.softuni.pathfinder.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class PathfinderUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public PathfinderUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return userRepository
                .findByUsername(username)
                .map(this::mapUser)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found!"));
    }


    private UserDetails mapUser(UserEntity userEntity) {

        return new PathfinderUserDetails(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getFullName(),
                userEntity.getAge(),
                userEntity.getLevel().name(),
                userEntity.getRole()
                        .stream().map(this::mapRole)
                        .toList()

        );
    }

    private GrantedAuthority mapRole(RoleEntity userRole) {

        return new SimpleGrantedAuthority("ROLE_" +
                userRole.getName().name());
    }
}
