package com.example.productshopxml.repository;

import com.example.productshopxml.model.dto.CategoryWithInfoDto;
import com.example.productshopxml.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

//    @Query("SELECT c.name, COUNT(p.id), AVG(p.price), SUM(p.price)" +
//            " FROM Category c" +
//            " JOIN Product p" +
//            " GROUP BY c.name" +
//            " ORDER BY COUNT(p.id)")
//    List<Category>  getAllCategoriesOrderByProductCount();

    @Query("SELECT new com.example.productshopxml.model.dto.CategoryWithInfoDto(" +
            "c.name, COUNT(p), AVG(p.price), SUM(p.price))" +
            " FROM Product p" +
            " JOIN p.categories c" +
            " GROUP BY c" +
            " ORDER BY COUNT(p) DESC")
    List<CategoryWithInfoDto>getAllCategoriesOrderByProductCount();
}
