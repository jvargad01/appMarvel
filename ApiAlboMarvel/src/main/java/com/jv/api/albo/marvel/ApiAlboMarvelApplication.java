package com.jv.api.albo.marvel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories 
@SpringBootApplication 
public class ApiAlboMarvelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAlboMarvelApplication.class, args);
	}

}
