package com.example.mySelectShop.repository;

import com.example.mySelectShop.entity.Product;
import com.example.mySelectShop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByUser(User user);
}
