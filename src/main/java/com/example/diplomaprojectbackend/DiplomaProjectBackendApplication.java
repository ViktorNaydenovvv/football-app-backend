package com.example.diplomaprojectbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class DiplomaProjectBackendApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DiplomaProjectBackendApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8080"));
		app.run(args);
	}
}
