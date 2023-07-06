package com.example.productshopxml.repository;

import com.example.productshopxml.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



//    @Query("SELECT u FROM User u" +
//            " JOIN u.soldProducts sp" +
//            " JOIN u.sellingItems si" +
//            " WHERE sp.buyer.lastName IS NOT NULL" +
//            " ORDER BY u.lastName, u.firstName")
//    @Query("SELECT u FROM User u" +
//            " WHERE (SELECT COUNT(p) FROM Product p WHERE p.seller.id = u.id AND p.buyer IS NOT NULL) > 0" +
//            " ORDER BY u.lastName, u.firstName")
//    @Query(
//            value = """
//                    SELECT * FROM users u
//                    JOIN products p on u.id = p.seller_id
//                    WHERE p.buyer_id IS NOT NULL
//                    ORDER BY u.last_name, u.first_name
//                    """,
//            nativeQuery = true
//    )
    List<User> findUserBySoldProductsIsNotNullAndSellingItemsIsNotEmptyOrderByLastNameAscFirstNameAsc();
    @Query("SELECT u FROM User u" +
            " JOIN u.sellingItems sp" +
            " WHERE sp.buyer IS NOT NULL " +
            "ORDER BY size(u.soldProducts) DESC, u.lastName ASC")
    List<User> findAllUsersAndProducts();
}
