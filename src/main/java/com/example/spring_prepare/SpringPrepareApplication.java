package com.example.spring_prepare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // Spring Security 인증 기능 제외

public class SpringPrepareApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPrepareApplication.class, args);
	}
}
