package com.ebenezer.weather.service;

import com.ebenezer.weather.client.OpenWeatherClient;
import com.ebenezer.weather.exception.CityNotFoundException;
import com.ebenezer.weather.model.WeatherResponse;
import com.ebenezer.weather.utils.WeatherResponseMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService{

    @Value("${app.id}")
    private String api_key;

    private final WeatherResponseMapper mapper;

    private final OpenWeatherClient openWeatherClient;

    @Override
    public WeatherResponse getWeather(String city) throws JsonProcessingException {
        if(city.isEmpty()){
            throw new CityNotFoundException("Invalid City");
        }
        ResponseEntity<String> weather = openWeatherClient.getWeather(city, api_key);

        return mapper.convertJsonResponseToWeatherResponse(weather.getBody());
    }
}
