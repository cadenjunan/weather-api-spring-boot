package com.weather.api.main.configuration;

import java.util.HashMap;
import java.util.Map;

import com.weather.api.main.weatherrequest.WeatherRequest;

public class WeatherRequestAPIMapper {
    private Map<String, WeatherRequest> requestAPIMapper;

    public WeatherRequestAPIMapper(Map<String, WeatherRequest> requestAPIMapper) {
        this.requestAPIMapper = requestAPIMapper;
    }

    public WeatherRequest getRequester(String name) {
        return this.requestAPIMapper.get(name);
    }

    public static class APIMapperBuilder {
        private Map<String, WeatherRequest> requestAPIMapper;

        private APIMapperBuilder() {
            this.requestAPIMapper = new HashMap<>();
        }

        public static APIMapperBuilder builder() {
            return new APIMapperBuilder();
        }

        public APIMapperBuilder add(String name, WeatherRequest request) {
            this.requestAPIMapper.put(name, request);
            return this;
        }

        public APIMapperBuilder add(String name, String uri) {
            this.requestAPIMapper.put(name, new WeatherRequest(uri));
            return this;
        }

        public WeatherRequestAPIMapper build() {
            return new WeatherRequestAPIMapper(requestAPIMapper);
        }
    }

}
