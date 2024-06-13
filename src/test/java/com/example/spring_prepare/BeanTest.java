package com.example.spring_prepare;

import com.example.spring_prepare.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {
    // 1번 방식
    //    @Autowired
    //    Food pizza;
    //
    //    @Autowired
    //    Food chicken;
    //
    //    @Test
    //    @DisplayName("테스트")
    //    void test1() {
    //        pizza.eat();
    //        chicken.eat();
    //    }

    // 2번 방식
    //    @Autowired
    //    Food food;
    //
    //    @Test
    //    @DisplayName("테스트")
    //    void test1() {
    //        food.eat();
    //    }

    // 3번 방식
    @Autowired
    @Qualifier("pizza")
    Food food;

    @Test
    @DisplayName("Primary와 Qualifier 우선순위 확인")
    void test1() {
        food.eat();
    }
}
