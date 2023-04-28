package com.ebenezer.weather.controller;

import com.ebenezer.weather.model.WeatherResponse;
import com.ebenezer.weather.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService service;

    @GetMapping("/openweather")
    public WeatherResponse getWeather(@RequestParam String city) throws JsonProcessingException {

        return service.getWeather(city);
    }
}
