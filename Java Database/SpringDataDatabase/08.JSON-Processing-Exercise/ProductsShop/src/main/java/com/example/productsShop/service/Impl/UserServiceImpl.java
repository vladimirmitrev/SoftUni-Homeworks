package com.example.productsShop.service.Impl;

import com.example.productsShop.model.dto.UserSoldDto;
import com.example.productsShop.model.dto.UsersAndProductsDto;
import com.example.productsShop.model.dto.UsersSoldProductsWithAgeDto;
import com.example.productsShop.model.entity.User;
import com.example.productsShop.repository.UserRepository;
import com.example.productsShop.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public User findRandomUser() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, userRepository.count() + 1);

        return userRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    @Transactional
    public List<UserSoldDto> findAllUsersWithMoreThanOneSoldProducts() {
        return userRepository.findAllUserWithMoreThanOneSoldProductOrderByLastNameThenByFirstName()
                .stream()
                .map(user -> modelMapper.map(user, UserSoldDto.class))
                .collect(Collectors.toList());
    }

//    @Override
//    @Transactional
//    public List<User> getUsersWithSoldProductsOrderByProductCount() {
//        List<User> allUserWithMoreThanOneSoldProductOrderCount = this.userRepository.findAllUserWithMoreThanOneSoldProductOrderCount();
//        return null;
//    }


    @Override
    @Transactional
    public UsersAndProductsDto usersAndProducts() {


        List<User> users = userRepository.usersAndProducts();


        List<UsersSoldProductsWithAgeDto> usersSoldProductsList = users.stream()
                .map(u -> {
                    UsersSoldProductsWithAgeDto user = modelMapper.map(u, UsersSoldProductsWithAgeDto.class);

                    user.getSoldProducts().setCount(u.getSoldProducts().size());
//                    List<ProductNameAndPriceDto> products = u.getSoldProducts().stream()
//                            .map(product -> mapper.map(product, ProductNameAndPriceDto.class))
//                            .collect(Collectors.toList());
//
//                    user.getProducts().setSoldProducts(products);
                    return user;
                })
                .collect(Collectors.toList());
        UsersAndProductsDto usersAndProductsDto = new UsersAndProductsDto(usersSoldProductsList);

        return usersAndProductsDto;
    }
}
