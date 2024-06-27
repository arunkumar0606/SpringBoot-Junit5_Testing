package com.example.Junit5_testing;


import com.example.Junit5_testing.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Junit5TestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Junit5TestingApplication.class, args);

		System.out.println("App Started !");
	}

}
