package com.example.samuelWeatherService.Service;

import com.example.samuelWeatherService.Dto.WeatherResponse;

public interface WeatherService {

    public WeatherResponse weatherForecast(String query);
}
