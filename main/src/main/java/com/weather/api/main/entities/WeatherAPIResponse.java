package com.weather.api.main.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WeatherAPIResponse {
    @JsonProperty("code")
    private int code;

    @JsonProperty("errMsg")
    private String errMsg;

    @JsonProperty("data")
    private Data data;
   
}
