package com.example.samuelWeatherService.Service.Implementation;


import com.example.samuelWeatherService.CustomErrorHandler.ErrorHandler;
import com.example.samuelWeatherService.Dto.WeatherResponse;
import com.example.samuelWeatherService.Client.WeatherClient;
import com.example.samuelWeatherService.Entity.Weather;
import com.example.samuelWeatherService.Service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherClient weatherClient;

    @Override
    @Cacheable("weather")
    public WeatherResponse weatherForecast(String query) {
        //check if query is not empty
        if(query.isEmpty()){
            throw new ErrorHandler("no value was provided");
        }
        Weather weather = weatherClient.weatherForecast(query);
        //response
        return new WeatherResponse(weather.getTemp(),weather.getWind_speed(),weather.getHumidity());
    }
}
