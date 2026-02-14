package com.weather.api.main.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Data {
    @JsonProperty("stations")
    private List<Station> stations;

    @JsonProperty("readings")
    private List<Reading> readings;

    @JsonProperty("readingType")
    private String readingType;

    @JsonProperty("readingUnit")
    private String readingUnit;

    @JsonProperty("paginationToken")
    private String paginationToken;
}
