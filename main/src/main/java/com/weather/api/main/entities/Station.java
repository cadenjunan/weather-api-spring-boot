package com.weather.api.main.entities;



import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Station {
    @JsonProperty("id")
    private String id;

    @JsonProperty("deviceId")
    private String deviceId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("location")
    private Location location;
}
