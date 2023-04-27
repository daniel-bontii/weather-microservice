package com.example.samuelWeatherService.Configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("weather")
public class WeatherClientProperties {
    private String url;
    private String apiKey;
    private String apiHost;
}
