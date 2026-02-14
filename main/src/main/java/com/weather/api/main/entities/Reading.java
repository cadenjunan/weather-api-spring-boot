package com.weather.api.main.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Reading {
    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("data")
    private List<ReadingData> data;
}
