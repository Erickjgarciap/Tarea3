package com.consulting.mgt.springboot.practica24.feign.agemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// Habilita Feign Clients
@EnableEurekaClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Define bean Logger.Level feignLoggerLevel
}
