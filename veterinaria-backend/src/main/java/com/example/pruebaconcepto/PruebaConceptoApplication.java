package com.example.pruebaconcepto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.pruebaconcepto.repositories")
public class PruebaConceptoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaConceptoApplication.class, args);
	}

}
