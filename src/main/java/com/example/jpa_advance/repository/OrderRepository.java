package com.example.jpa_advance.repository;

import com.example.jpa_advance.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
