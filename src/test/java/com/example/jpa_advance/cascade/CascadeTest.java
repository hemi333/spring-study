package com.example.jpa_advance.cascade;

import com.example.jpa_advance.entity.Food;
import com.example.jpa_advance.entity.User;
import com.example.jpa_advance.repository.FoodRepository;
import com.example.jpa_advance.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class CascadeTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    FoodRepository foodRepository;

    @Test
    @DisplayName("Robbie 음식 주문")
    void test1() {
        // 고객 Robbie 가 후라이드 치킨과 양념 치킨을 주문합니다.
        User user = new User();
        user.setName("Robbie");

        // 후라이드 치킨 주문
        Food food = new Food();
        food.setName("후라이드 치킨");
        food.setPrice(15000);

        user.addFoodList(food);

        Food food2 = new Food();
        food2.setName("양념 치킨");
        food2.setPrice(20000);

        user.addFoodList(food2);

        userRepository.save(user);
        foodRepository.save(food);
        foodRepository.save(food2);
    }

    @Test
    @DisplayName("영속성 전이 저장")
    void test2() {
        // 고객 Robbie 가 후라이드 치킨과 양념 치킨을 주문합니다.
        User user = new User();
        user.setName("Robbie");

        // 후라이드 치킨 주문
        Food food = new Food();
        food.setName("후라이드 치킨");
        food.setPrice(15000);

        user.addFoodList(food);

        Food food2 = new Food();
        food2.setName("양념 치킨");
        food2.setPrice(20000);

        user.addFoodList(food2);

        userRepository.save(user); // 3번 저장할 것을 한 번에 끝냄
    }

    @Test
    @Transactional // 지연로딩은 트랜잭션 환경 필요
    @Rollback(value = false)
    @DisplayName("Robbie 탈퇴")
    void test3() {
        // 고객 Robbie 를 조회합니다.
        User user = userRepository.findByName("Robbie");
        System.out.println("user.getName() = " + user.getName());

        // Robbie 가 주문한 음식 조회
        for (Food food : user.getFoodList()) {
            System.out.println("food.getName() = " + food.getName());
        }

        // 주문한 음식 데이터 삭제
        foodRepository.deleteAll(user.getFoodList());

        // Robbie 탈퇴
        userRepository.delete(user);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("영속성 전이 삭제")
    void test4() {
        // 고객 Robbie 를 조회합니다.
        User user = userRepository.findByName("Robbie");
        System.out.println("user.getName() = " + user.getName());

        // Robbie 가 주문한 음식 조회
        for (Food food : user.getFoodList()) {
            System.out.println("food.getName() = " + food.getName());
        }

        // Robbie 탈퇴
        userRepository.delete(user);
    }
}
