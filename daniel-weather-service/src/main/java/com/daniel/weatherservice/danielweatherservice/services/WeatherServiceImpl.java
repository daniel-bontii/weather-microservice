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

    private WeatherConditionsDto ConditionsToWeatherConditionsDto(WeatherConditions conditions)  {
        Data data = conditions.getData().get(0);
        return new WeatherConditionsDto(data.getTemp(), data.getWind_spd(), data.getRh());
    }

    @Override
    public WeatherConditionsDto getWeatherByCity(String city) {

        //Todo: Validate city
        WeatherConditions conditions = weatherbitService.getWeatherByCity(city);
        return ConditionsToWeatherConditionsDto(conditions);

    }

    @Override
    public WeatherConditionsDto getWeatherByZip(int zip) {

        //Todo: Validate zip
        WeatherConditions conditions = weatherbitService.getWeatherByZip(zip);
        return ConditionsToWeatherConditionsDto(conditions);
    }
}
