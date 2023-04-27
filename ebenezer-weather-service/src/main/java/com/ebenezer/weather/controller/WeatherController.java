package com.ebenezer.weather.controller;

import com.ebenezer.weather.client.OpenWeatherClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    @Value("${app.id}")
    private String api_key;

    private final OpenWeatherClient openWeatherClient;

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city){
        System.out.println(openWeatherClient.getWeather(city, api_key).getBody());
        return "Hello";
    }
}
