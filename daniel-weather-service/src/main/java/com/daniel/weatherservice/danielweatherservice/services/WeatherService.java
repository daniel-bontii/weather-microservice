package com.daniel.weatherservice.danielweatherservice.services;

import com.daniel.weatherservice.danielweatherservice.dto.WeatherConditionsDto;

public interface WeatherService {
    WeatherConditionsDto getWeatherByCity(String city);
    WeatherConditionsDto getWeatherByZip(int zip);
}
