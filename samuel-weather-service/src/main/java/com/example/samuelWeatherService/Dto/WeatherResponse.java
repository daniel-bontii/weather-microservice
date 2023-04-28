package com.example.samuelWeatherService.Dto;


public record WeatherResponse(
        double temperature,
        double windSpeed,
        double humidity
) { }
