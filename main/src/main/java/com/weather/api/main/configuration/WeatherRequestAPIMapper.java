package com.weather.api.main.configuration;

import java.util.HashMap;
import java.util.Map;

import com.weather.api.main.entities.WeatherAPIResponse;
import com.weather.api.main.error.InvalidDateFormatException;
import com.weather.api.main.service.DateParamValidator;
import com.weather.api.main.weatherrequest.WeatherRequest;

public class WeatherRequestAPIMapper {
    private Map<String, WeatherRequest> requestAPIMapper;
    private DateParamValidator dateParamValidator;
    public WeatherRequestAPIMapper(Map<String, WeatherRequest> requestAPIMapper, DateParamValidator dateParamValidator) {
        this.requestAPIMapper = requestAPIMapper;
        this.dateParamValidator = dateParamValidator;
    }

    public WeatherAPIResponse getDataReading(String name){
        return this.requestAPIMapper.get(name).getReadings();
    }
    public String getDataReadingText(String name){
        return this.requestAPIMapper.get(name).getReadingsInText();
    }

    public WeatherAPIResponse getDataReadingByDate(String name, String dateString){
        boolean validDateFormat = this.dateParamValidator.validate(dateString);
        if(!validDateFormat){
            throw new InvalidDateFormatException();
        }
        return this.requestAPIMapper.get(name).getReadindgsWithDate(dateString);
    }

    public static class APIMapperBuilder {
        private Map<String, WeatherRequest> requestAPIMapper;
        private DateParamValidator dateParamValidator;
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
        public APIMapperBuilder addDateStringValidator(DateParamValidator dateParamValidator){
            this.dateParamValidator = dateParamValidator;
            return this;
        }

        public APIMapperBuilder add(String name, String uri) {
            this.requestAPIMapper.put(name, new WeatherRequest(uri));
            return this;
        }

        public WeatherRequestAPIMapper build() {
            return new WeatherRequestAPIMapper(requestAPIMapper, dateParamValidator);
        }
    }

}
