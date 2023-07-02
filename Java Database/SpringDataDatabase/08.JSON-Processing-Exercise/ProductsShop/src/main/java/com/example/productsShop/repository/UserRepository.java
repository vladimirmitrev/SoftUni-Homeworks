package com.example.productsShop.repository;

import com.example.productsShop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u" +
            " JOIN u.sellingItems si" +
            " WHERE si.buyer IS NOT NULL")
    List<User> findAllUserWithMoreThanOneSoldProductOrderByLastNameThenByFirstName();

    @Query("SELECT u FROM User u" +
            " JOIN u.sellingItems si" +
            " WHERE si.buyer IS NOT NULL " +
            "ORDER BY size(u.soldProducts) DESC, u.lastName ASC")
    List<User>usersAndProducts();


}
