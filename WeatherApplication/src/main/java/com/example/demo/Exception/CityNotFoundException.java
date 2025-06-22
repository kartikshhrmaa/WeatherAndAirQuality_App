package com.example.demo.Exception;

//custom exception class
public class CityNotFoundException extends RuntimeException{
	public CityNotFoundException(String message) {
		super(message);
	}

}
