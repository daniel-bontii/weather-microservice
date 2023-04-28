package com.daniel.weatherservice.danielweatherservice.controllers;

import com.daniel.weatherservice.danielweatherservice.httpclient.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;


}
