package com.daniel.weatherservice.danielweatherservice.httpclient;

import com.daniel.weatherservice.danielweatherservice.model.WeatherConditions;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface WeatherbitService {

    @GetExchange
    WeatherConditions getWeatherByCity(@RequestParam String city);

    @GetExchange
    WeatherConditions getWeatherByZip(@RequestParam(name = "postal_code") int zip);

}
