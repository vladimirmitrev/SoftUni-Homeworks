package com.resellerapp.repository;

import com.resellerapp.model.entity.UserEntity;
import com.resellerapp.model.service.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsernameOrPassword(String username, String email);

    Optional<UserEntity> findByUsernameAndPassword(String username, String password);
}
