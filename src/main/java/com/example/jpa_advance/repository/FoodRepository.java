package com.example.jpa_advance.repository;

import com.example.jpa_advance.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}