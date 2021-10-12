package com.xoriant.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // Auto Discovery
public class Application {

	public static void main(String[] args) {
		
		System.out.println("<<<<<< Before Banner >>>>>>>>");
		
		SpringApplication.run(Application.class, args);
		

	}

}
