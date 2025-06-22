package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import com.example.demo.DTO.ForecastRes;
import com.example.demo.DTO.ForecastRes.ForecastData;
import com.example.demo.DTO.WeatherReq;
import com.example.demo.DTO.WeatherRes;
import com.example.demo.Exception.CityNotFoundException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

	//adding values from applicaiton.property
    @Value("${openweathermap.api.url}")
    private String weatherUrl;

    @Value("${openweathermap.api.key}")
    private String weatherKey;

    @Value("${iqair.api.url}")
    private String airUrl;

    @Value("${iqair.api.key}")
    private String airKey;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherRes getWeatherData(WeatherReq request) {
        String city = request.getCity().trim();


        // 1. Fetch Weather - building weather api url
        @SuppressWarnings("deprecation")
        String weatherApiUrl = UriComponentsBuilder.fromHttpUrl(weatherUrl)
                .queryParam("q", city)
                .queryParam("appid", weatherKey)
                .queryParam("units", "metric")
                .toUriString();

        try {
            String weatherJsonStr = restTemplate.getForObject(weatherApiUrl, String.class);
            
            JSONObject weatherJson = new JSONObject(weatherJsonStr);
            //convert raw json into json object
            
            //extracting weather data
            //coor - coordinates(latitude,longitude)
            double lat = weatherJson.getJSONObject("coord").getDouble("lat");
            double lon = weatherJson.getJSONObject("coord").getDouble("lon");
            double temp = weatherJson.getJSONObject("main").getDouble("temp");
            double feelsLike = weatherJson.getJSONObject("main").getDouble("feels_like");
            int humidity = weatherJson.getJSONObject("main").getInt("humidity");
            String condition = weatherJson.getJSONArray("weather").getJSONObject(0).getString("description");

            // 2. Fetch Air Quality from IQAir - Build IQAir API URL
            String airQualityUrl = UriComponentsBuilder.fromHttpUrl(airUrl)
                    .queryParam("lat", lat)
                    .queryParam("lon", lon)
                    .queryParam("key", airKey)
                    .toUriString();

            String airJsonStr = restTemplate.getForObject(airQualityUrl, String.class);
            JSONObject airJson = new JSONObject(airJsonStr);
            int aqi = airJson.getJSONObject("data").getJSONObject("current").getJSONObject("pollution").getInt("aqius");

            String airQuality = getAQICategory(aqi) + " (AQI: " + aqi + ")";
            String healthAdvice = getHealthAdvice(aqi);

            return new WeatherRes (
                    city, temp, feelsLike, humidity, condition, lat, lon,
                    airQuality, healthAdvice,
                    Instant.now().toString(),
                    "/api/weather/" + city + "/forecast"
            );

        } catch (Exception e) {
            throw new CityNotFoundException("City not found or data unavailable.");
        }
    }
    //forecast data
    public ForecastRes getForecastData(WeatherReq request) {
        String city = request.getCity().trim();

        String forecastApiUrl = UriComponentsBuilder.fromHttpUrl("https://api.openweathermap.org/data/2.5/forecast")
                .queryParam("q", city)
                .queryParam("appid", weatherKey)
                .queryParam("units", "metric")
                .toUriString();

        try {
            String forecastJsonStr = restTemplate.getForObject(forecastApiUrl, String.class);
            JSONObject forecastJson = new JSONObject(forecastJsonStr);

            List<ForecastData> forecastList = new ArrayList<>();
            for (int i = 0; i < forecastJson.getJSONArray("list").length(); i++) {
                JSONObject item = forecastJson.getJSONArray("list").getJSONObject(i);
                String dateTime = item.getString("dt_txt");
                double temp = item.getJSONObject("main").getDouble("temp");
                String condition = item.getJSONArray("weather").getJSONObject(0).getString("description");

                forecastList.add(new ForecastData(dateTime, temp, condition));
            }

            return new ForecastRes(city, forecastList);

        } catch (Exception e) {
            throw new CityNotFoundException("Forecast not available for city: " + city);
        }
    }


    private String getAQICategory(int aqi) {
        if (aqi <= 50) return "Looks Good";
        else if (aqi <= 100) return "Moderate";
        else if (aqi <= 150) return "Unhealthy for Sensitive Groups";
        else if (aqi <= 200) return "Unhealthy";
        else if (aqi <= 300) return "Very Unhealthy";
        else return "Hazardous";
    }

    private String getHealthAdvice(int aqi) {
        if (aqi <= 50) return "the air is as fresh as our first love under cherry blossoms 🌸✨ ";
        else if (aqi <= 100) return "Sensitive groups should reduce outdoor exertion \n but wear a mask, okay? I can't lose you 😷💔";
        else if (aqi <= 150) return "you're too precious for this dusty drama 😤💨 stay indoors";
        else if (aqi <= 200) return "the air is as toxic as a demon unleashed. Only the cautious shall endure. 💔😭";
        else return "Avoid all outdoor activities.";
    }
}