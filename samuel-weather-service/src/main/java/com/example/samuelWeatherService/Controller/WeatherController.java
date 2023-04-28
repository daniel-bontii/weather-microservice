package com.example.samuelWeatherService.Controller;


import com.example.samuelWeatherService.Dto.WeatherResponse;
import com.example.samuelWeatherService.Service.Implementation.WeatherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherServiceImpl weatherServiceImpl;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public WeatherResponse weatherForecast(@RequestParam String city){

        return weatherServiceImpl.weatherForecast(city);
    }
}
