package com.example.samuelWeatherService.CustomErrorHandler;


public class ErrorHandler extends  RuntimeException{
    public ErrorHandler(String message) {
        super(message);
    }

}
