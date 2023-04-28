package com.ebenezer.weather.config;

import com.ebenezer.weather.client.OpenWeatherClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebConfig {

    @Value("${openWeather.baseUrl}")
    String baseUrl;

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    @Bean
    public OpenWeatherClient openWeatherClient(){
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient()))
                        .build();

        return httpServiceProxyFactory.createClient(OpenWeatherClient.class);
    }
}
