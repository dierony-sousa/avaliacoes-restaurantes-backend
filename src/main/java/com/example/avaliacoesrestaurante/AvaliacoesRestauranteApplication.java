package com.example.avaliacoesrestaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvaliacoesRestauranteApplication {

	public static void main(String[] args) {
		System.setProperty("h2.server.web-allow-others", "true");
		SpringApplication.run(AvaliacoesRestauranteApplication.class, args);
	}

}
