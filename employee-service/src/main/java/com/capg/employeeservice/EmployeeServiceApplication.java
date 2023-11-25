package com.capg.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.modelmapper.ModelMapper;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	@Bean
	public ModelMapper ModelMapper() {
		return new ModelMapper();
	}
	
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	
//	@Bean
//	public WebClient webClient() {
//		return WebClient.builder().build();
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
