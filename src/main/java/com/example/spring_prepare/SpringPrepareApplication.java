package com.example.spring_prepare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringPrepareApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPrepareApplication.class, args);
	}
}

