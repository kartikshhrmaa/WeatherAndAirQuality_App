package com.example.demo.DTO;
import java.util.List;

public class ForecastRes {
    private String city;
    private List<ForecastData> forecast;

    public ForecastRes(String city, List<ForecastData> forecast) {
        this.city = city;
        this.forecast = forecast;
    }

    public static class ForecastData {
        private String dateTime;
        private double temperature;
        private String condition;

        public ForecastData(String dateTime, double temperature, String condition) {
            this.dateTime = dateTime;
            this.temperature = temperature;
            this.condition = condition;
        }

        public String getDateTime() {
            return dateTime;
        }

        public double getTemperature() {
            return temperature;
        }

        public String getCondition() {
            return condition;
        }
    }

    public String getCity() {
        return city;
    }

    public List<ForecastData> getForecast() {
        return forecast;
    }
}