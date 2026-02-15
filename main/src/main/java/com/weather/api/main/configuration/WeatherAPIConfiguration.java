package com.weather.api.main.configuration;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.weather.api.main.service.DateFormatValidator;
import com.weather.api.main.service.DateParamValidator;

@Configuration
public class WeatherAPIConfiguration {

    @Bean
    DateParamValidator dateParamValidator() {
        return DateParamValidator.builder().addValidator(
                new DateFormatValidator(DateTimeFormatter.ISO_LOCAL_DATE))
                .addValidator(new DateFormatValidator(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();
    }

    @Bean
    WeatherRequestAPIMapper weatherRequestAPIMapper(DateParamValidator dateParamValidator) {
        return WeatherRequestAPIMapper.APIMapperBuilder.builder()
                .add("air-temperature", "https://api-open.data.gov.sg/v2/real-time/api/air-temperature")
                .add("rainfall", "https://api-open.data.gov.sg/v2/real-time/api/rainfall")
                .addDateStringValidator(dateParamValidator)
                .build();
    }
}
