package com.ebenezer.weather.utils;

import com.ebenezer.weather.model.WeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class WeatherResponseMapper {

    public WeatherResponse convertJsonResponseToWeatherResponse(String jsonResponse) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonResponse);
        double temperature = jsonNode.get("main").get("temp").asDouble();
        double windSpeed = jsonNode.get("wind").get("speed").asDouble();
        int humidity = jsonNode.get("main").get("humidity").asInt();

        return new WeatherResponse(temperature, windSpeed, humidity);
    }
}
