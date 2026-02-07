package com.weather.api.main.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.weather.api.main.configuration.WeatherRequestAPIMapper;
import com.weather.api.main.weatherrequest.WeatherRequest;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WeatherRequestController {

    private WeatherRequestAPIMapper weatherRequestAPIMapper;

    public WeatherRequestController(WeatherRequestAPIMapper weatherRequestAPIMapper) {
        this.weatherRequestAPIMapper = weatherRequestAPIMapper;
    }

    @GetMapping("/air-temperature")
    public String getAirTemp() {
        WeatherRequest weatherRequest = weatherRequestAPIMapper.getRequester("air-temperature");
        return weatherRequest.getReadings();
    }

}
