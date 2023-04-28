package com.daniel.weatherservice.danielweatherservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherConditionsDto {

    private String temperature;
    private String windSpeed;
    private String humidity;
}
