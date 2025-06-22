package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ForecastRes;
import com.example.demo.DTO.WeatherReq;
import com.example.demo.DTO.WeatherRes;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @PostMapping
    public ResponseEntity<WeatherRes> getWeather(@Valid @RequestBody WeatherReq request) {
        WeatherRes response = weatherService.getWeatherData(request);
        return ResponseEntity.ok(response);
    	}
    
    @PostMapping("/forecast")
    public ResponseEntity<ForecastRes> getForecast(@Valid @RequestBody WeatherReq request) {
        ForecastRes forecast = weatherService.getForecastData(request);
        return ResponseEntity.ok(forecast);
    }
}
