package com.weather.api.main.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.weather.api.main.configuration.WeatherRequestAPIMapper;
import com.weather.api.main.entities.WeatherAPIResponse;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class WeatherRequestController {

    private WeatherRequestAPIMapper weatherRequestAPIMapper;

    public WeatherRequestController(WeatherRequestAPIMapper weatherRequestAPIMapper) {
        this.weatherRequestAPIMapper = weatherRequestAPIMapper;
    }

    @GetMapping("/air-temperature")
    public WeatherAPIResponse getAirTemp(@RequestParam(name = "date")Optional<String> dateTime) {

       
        if (dateTime.isPresent()) {
            return weatherRequestAPIMapper.getDataReadingByDate("air-temperature", dateTime.get());
        }
        return weatherRequestAPIMapper.getDataReading("air-temperature");
    }

    @GetMapping("/air-temperature/text")
    public String getAirTempInText() {
        
        return weatherRequestAPIMapper.getDataReadingText("air-temperature");
    }

}
