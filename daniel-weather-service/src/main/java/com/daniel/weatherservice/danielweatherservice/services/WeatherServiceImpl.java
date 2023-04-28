package com.daniel.weatherservice.danielweatherservice.services;

import com.daniel.weatherservice.danielweatherservice.dto.WeatherConditionsDto;
import com.daniel.weatherservice.danielweatherservice.httpclient.WeatherbitService;
import com.daniel.weatherservice.danielweatherservice.model.Data;
import com.daniel.weatherservice.danielweatherservice.model.WeatherConditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherbitService weatherbitService;

    @Override
    public WeatherConditionsDto getWeatherByCity(String city) {
        WeatherConditions conditions = weatherbitService.getWeatherByCity(city);
        Data data = conditions.getData().get(0);

        return new WeatherConditionsDto(data.getTemp(), data.getWind_spd(), data.getRh());
    }
}
