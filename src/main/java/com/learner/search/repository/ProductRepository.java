package com.learner.search.repository;

import com.learner.search.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {


    @Query("SELECT p FROM Product p WHERE " +
            "p.name LIKE CONCAT('%', :query,'%') " +
            "OR p.description LIKE CONCAT('%', :query, '%')")
    List<Product> searchProducts(String query);

    @NativeQuery(value = "SELECT * FROM products p WHERE " +
            "p.name LIKE CONCAT('%', :query,'%') " +
            "OR p.description LIKE CONCAT('%', :query, '%')")
    List<Product> searchProductsSQL(String query);

}
