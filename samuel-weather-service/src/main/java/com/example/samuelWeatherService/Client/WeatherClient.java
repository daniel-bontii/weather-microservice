package com.example.samuelWeatherService.Client;

import com.example.samuelWeatherService.Entity.Weather;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;


@HttpExchange(accept = MediaType.APPLICATION_JSON_VALUE)
public interface WeatherClient {

    @GetExchange
    public Weather weatherForecast(@RequestParam String city);
}
