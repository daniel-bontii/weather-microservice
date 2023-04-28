package com.daniel.weatherservice.danielweatherservice.httpclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Value("${weatherstack.access.key}")
    private String accessKey;

    @Bean
    WeatherService weatherService() {
        String baseUrl = "https://api.weatherstack.com/current?access_key=" + accessKey;
        WebClient webClient = WebClient.builder().baseUrl(baseUrl).build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
        return factory.createClient(WeatherService.class);
    }

}
