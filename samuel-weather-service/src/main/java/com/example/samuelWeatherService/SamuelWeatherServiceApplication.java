package com.example.samuelWeatherService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SamuelWeatherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamuelWeatherServiceApplication.class, args);
	}

}
