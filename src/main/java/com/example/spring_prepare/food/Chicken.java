package com.example.spring_prepare.food;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// 2번 방식
@Primary
public class Chicken implements Food {
    @Override
    public void eat() {
        System.out.println("치킨을 먹습니다.");
    }
}