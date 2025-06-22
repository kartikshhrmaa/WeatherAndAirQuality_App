package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) {
		/*
		 Weather Application and Air Quality Monitoring App
		 .added custom health advice and forecast URLs to make the API more user-friendly
		 Tech Stack: Java, Spring Boot, REST API, OpenWeatherMap API, IQAir API, JSON, Maven
		 
		 .developed a Spring Boot-based RESTful application to provide real-time weather data (temperature, humidity, conditions) 
		 and air quality index (AQI) with personalized health recommendations.
		 .Integrated OpenWeatherMap API to fetch weather forecasts and IQAir API for air pollution data using latitude and longitude inputs
		 .Implemented input validation, structured exception handling, and unit testing to ensure reliability and clean error messaging.
		 .Built extensible architecture with modular service classes, DTOs using Lombok, and forecast endpoint support.
		 .Optimized API performance and error responses for smooth user experience
		 */
		
		System.out.println("Weather Application... ");
		SpringApplication.run(WeatherApplication.class, args);
		
		System.out.println("Weather Application created successfully!! ");
	}

}
