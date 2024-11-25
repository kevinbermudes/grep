package com.example.grep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrepApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrepApplication.class, args);
		System.out.print("hola putito");
	}

}
