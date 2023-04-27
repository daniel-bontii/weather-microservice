package com.ebenezer.weather.service;

import com.ebenezer.weather.model.WeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface WeatherService {

    WeatherResponse getWeather(String city) throws JsonProcessingException;
}
