package com.weather.api.main.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.weather.api.main.configuration.WeatherRequestAPIMapper;
import com.weather.api.main.entities.WeatherAPIResponse;
import com.weather.api.main.weatherrequest.WeatherRequest;

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

        WeatherRequest weatherRequest = weatherRequestAPIMapper.getRequester("air-temperature");
        if (dateTime.isPresent()) {
            return weatherRequest.getReadindgsWithDate(dateTime.get());
        }
        return weatherRequest.getReadings();
    }

    @GetMapping("/air-temperature/text")
    public String getAirTempInText() {
        WeatherRequest weatherRequest = weatherRequestAPIMapper.getRequester("air-temperature");
        return weatherRequest.getReadingsInText();
    }

}
