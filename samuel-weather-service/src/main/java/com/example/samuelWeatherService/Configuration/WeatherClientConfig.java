package com.example.samuelWeatherService.Configuration;

import com.example.samuelWeatherService.Client.WeatherClient;
import com.example.samuelWeatherService.CustomErrorHandler.ErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

@Configuration
public class WeatherClientConfig {

    @Bean
    public WeatherClient weatherClient(WeatherClientProperties properties) {
        WebClient webClient = WebClient.builder()
                .baseUrl(properties.getUrl())
                .defaultHeader(properties.getApiHost(), properties.getApiKey())
                .defaultStatusHandler(
                        httpStatusCode -> HttpStatus.NOT_FOUND == httpStatusCode,
                        response -> Mono.just(new ErrorHandler("Weather server can not be found")))
                .defaultStatusHandler(
                        HttpStatusCode::is5xxServerError,
                        response -> Mono.error(new ErrorHandler("Error communicating with external server")))
                .defaultStatusHandler(
                        HttpStatusCode::isError,
                        response -> Mono.error(new ErrorHandler("Invalid value provided"))
                )
                .build();

        return HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build()
                .createClient(WeatherClient.class);

    }



}
