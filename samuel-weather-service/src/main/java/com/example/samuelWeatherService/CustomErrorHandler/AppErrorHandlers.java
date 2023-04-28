package com.example.samuelWeatherService.CustomErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AppErrorHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ErrorHandler.class)
    public ResponseEntity<Object> ErrorHandler(ErrorHandler errorHandler){
        Map<String,Object> error = new HashMap<>();
        error.put("message",errorHandler.getMessage());
        error.put("Date", LocalDateTime.now().toString());
        error.put("status",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
