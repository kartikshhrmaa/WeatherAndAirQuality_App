package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
//there is no need to insert getter and setter (lombok) dependency reduces boilerplate code for this.
public class WeatherReq {
	
	//adding validation
	@NotBlank(message = "Must enter City name!!")
	private String city;
	
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
