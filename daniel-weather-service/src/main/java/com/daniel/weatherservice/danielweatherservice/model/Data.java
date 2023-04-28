package com.daniel.weatherservice.danielweatherservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Data {

    private String rh;
    private String wind_spd;
    private String temp;


}

