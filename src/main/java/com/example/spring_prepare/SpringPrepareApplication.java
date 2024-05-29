package com.example.spring_prepare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringPrepareApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPrepareApplication.class, args);
	}
}

