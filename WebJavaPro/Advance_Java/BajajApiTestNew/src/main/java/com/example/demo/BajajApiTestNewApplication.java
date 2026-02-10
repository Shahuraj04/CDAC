package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo", "com.example.controller"})
public class BajajApiTestNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(BajajApiTestNewApplication.class, args);
	}

}