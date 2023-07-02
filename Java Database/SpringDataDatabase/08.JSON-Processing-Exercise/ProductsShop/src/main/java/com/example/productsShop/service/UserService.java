package com.example.productsShop.service;

import com.example.productsShop.model.dto.UserSoldDto;
import com.example.productsShop.model.dto.UsersAndProductsDto;
import com.example.productsShop.model.entity.User;

import java.util.List;

public interface UserService {

    User findRandomUser();

    List<UserSoldDto> findAllUsersWithMoreThanOneSoldProducts();

    UsersAndProductsDto usersAndProducts();
}


