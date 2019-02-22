package com.epam.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyProductServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProductServicesApplication.class, args);
		System.out.println("my service running ...");
	}

}
