package com.example.productshopxml.service.Impl;

import com.example.productshopxml.model.dto.seed._4dto.ProductCountDto;
import com.example.productshopxml.model.dto.seed._4dto.ProductWithNameAndPriceDto;
import com.example.productshopxml.model.dto.seed._4dto.UserFirstAndLastNameAgeDto;
import com.example.productshopxml.model.dto.seed._4dto.UserViewRootDto;
import com.example.productshopxml.model.dto.UserWithProductsRootDto;
import com.example.productshopxml.model.dto.UserWithSoldProductsDto;
import com.example.productshopxml.model.entity.Product;
import com.example.productshopxml.model.entity.User;
import com.example.productshopxml.repository.UserRepository;
import com.example.productshopxml.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
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
    public UserWithProductsRootDto findAllUserWithSoldProducts() {

        UserWithProductsRootDto userWithProductsRootDto = new UserWithProductsRootDto();

        userWithProductsRootDto
                .setUsers(userRepository.findUserBySoldProductsIsNotNullAndSellingItemsIsNotEmptyOrderByLastNameAscFirstNameAsc()
                        .stream()
                        .map(user -> modelMapper.map(user, UserWithSoldProductsDto.class))
                        .collect(Collectors.toList()));


        return userWithProductsRootDto;
    }

    @Override
    @Transactional
    public UserViewRootDto findAllUsersAndProducts() {


        List<User> users = userRepository.findAllUsersAndProducts();




        List<UserFirstAndLastNameAgeDto> usersSoldProductsList = users.stream()
                .map(u -> {
                    UserFirstAndLastNameAgeDto user = modelMapper.map(u, UserFirstAndLastNameAgeDto.class);

                    List<ProductWithNameAndPriceDto> nameAndPriceDtos = u.getSoldProducts()
                                    .stream()
                                            .map(product -> modelMapper.map(product, ProductWithNameAndPriceDto.class))
                                                    .collect(Collectors.toList());

                    ProductCountDto productCountDto = new ProductCountDto(nameAndPriceDtos);

                    user.setSoldProducts(productCountDto);
                    user.getSoldProducts().setCount(u.getSoldProducts().size());


                    return user;
                })
                .collect(Collectors.toList());

        UserViewRootDto userViewRootDto = new UserViewRootDto(usersSoldProductsList);

        return userViewRootDto;
    }

}
