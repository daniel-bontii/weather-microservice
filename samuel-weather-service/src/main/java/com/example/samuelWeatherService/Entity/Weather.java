package com.example.samuelWeatherService.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
   private double wind_speed;
   private double temp;
   private double humidity;
}
