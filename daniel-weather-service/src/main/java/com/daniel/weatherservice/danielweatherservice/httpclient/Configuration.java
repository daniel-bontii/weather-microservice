package com.daniel.weatherservice.danielweatherservice.httpclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Value("${weatherbit.access.key}")
    private String accessKey;

    @Bean
    WeatherbitService weatherService() {
        String baseUrl = "https://api.weatherbit.io/v2.0/current?key=" + accessKey;
        WebClient webClient = WebClient.builder().baseUrl(baseUrl).build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
        return factory.createClient(WeatherbitService.class);
    }

}
