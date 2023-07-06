package com.example.productshopxml.service;

import com.example.productshopxml.model.dto.seed._4dto.UserViewRootDto;
import com.example.productshopxml.model.dto.UserWithProductsRootDto;
import com.example.productshopxml.model.entity.User;

public interface UserService {

    User findRandomUser();

    UserWithProductsRootDto findAllUserWithSoldProducts();

    UserViewRootDto findAllUsersAndProducts();
}
