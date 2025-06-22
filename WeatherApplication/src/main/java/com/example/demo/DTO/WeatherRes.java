package com.example.demo.DTO;
/*
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor		//@NoArgsConstructor - generate constructor with no parameters

public class WeatherRes {
	//Here we have to write the fields that weather API should return
	
	private String city;
	private double temperature;
	private double feelsLike;
	private int humidity;
	private String condition;
	private double latitude;
	private double longitude;
	private String airQuality;
	private String healthAdvice;
	private String lastUpdate;
	private String forecastUrl;
	
}*/

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;

//@Setter
//@Getter
//@AllArgsConstructor		//@NoArgsConstructor - generate constructor with no parameters

//Here we have to write the fields that weather API should return

public class WeatherRes {
  private String city;
  private double temperature;
  private double feelsLike;
  private int humidity;
  private String condition;
  private double latitude;
  private double longitude;
  private String airQuality;
  private String healthAdvice;
  private String lastUpdate;
  private String forecastUrl;

  public WeatherRes(String city, double temperature, double feelsLike, int humidity, String condition,
                    double latitude, double longitude, String airQuality, String healthAdvice,
                    String lastUpdate, String forecastUrl) {
      this.city = city;
      this.temperature = temperature;
      this.feelsLike = feelsLike;
      this.humidity = humidity;
      this.condition = condition;
      this.latitude = latitude;
      this.longitude = longitude;
      this.airQuality = airQuality;
      this.healthAdvice = healthAdvice;
      this.lastUpdate = lastUpdate;
      this.forecastUrl = forecastUrl;
  }

  public String getCity() { return city; }
  public double getTemperature() { return temperature; }
  public double getFeelsLike() { return feelsLike; }
  public int getHumidity() { return humidity; }
  public String getCondition() { return condition; }
  public double getLatitude() { return latitude; }
  public double getLongitude() { return longitude; }
  public String getAirQuality() { return airQuality; }
  public String getHealthAdvice() { return healthAdvice; }
  public String getLastUpdate() { return lastUpdate; }
  public String getForecastUrl() { return forecastUrl; }

}

