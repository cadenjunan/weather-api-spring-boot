package com.weather.api.main.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ReadingData {

    @JsonProperty("stationId")
    private String stationId;

    @JsonProperty("value")
    private double value;
}
