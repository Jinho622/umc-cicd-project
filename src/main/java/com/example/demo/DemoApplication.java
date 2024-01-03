package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

// 1:N 하려면 MNAY TO ONE 은 무조건 써야함, ONETOMANY는 쓸 필요 없음(수정x)
