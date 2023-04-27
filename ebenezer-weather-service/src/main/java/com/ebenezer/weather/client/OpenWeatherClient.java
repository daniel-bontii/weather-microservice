package com.ebenezer.weather.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(accept = "application/json", contentType = "application/json")
public interface OpenWeatherClient {

    @GetExchange()
    ResponseEntity<Object> getWeather(@RequestParam(name = "q") String city, @RequestParam(name = "appid") String api_key);
}
