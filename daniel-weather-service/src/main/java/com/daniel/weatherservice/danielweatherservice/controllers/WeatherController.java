package com.daniel.weatherservice.danielweatherservice.controllers;

import com.daniel.weatherservice.danielweatherservice.dto.WeatherConditionsDto;
import com.daniel.weatherservice.danielweatherservice.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weatherbit")
    public WeatherConditionsDto getWeatherByCity(@RequestParam String city){
        return weatherService.getWeatherByCity(city);
    }

    @GetMapping("/api/v1/weather-by-zip")
    public WeatherConditionsDto getWeatherByZip(@RequestParam int zip){
        return weatherService.getWeatherByZip(zip);
    }

}
