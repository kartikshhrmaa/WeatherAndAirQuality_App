package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// indicates that the class has @Bean definition methods.
@Configuration
public class AppConfig {
	
	//bean annotation used to declare a method that produce a bean(obj) which is managed by spring IOC
	@Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
}