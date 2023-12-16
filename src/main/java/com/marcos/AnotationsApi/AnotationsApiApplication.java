package com.marcos.AnotationsApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnotationsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnotationsApiApplication.class, args);
		System.out.println("App rodando na porta 8080");
	}

}
