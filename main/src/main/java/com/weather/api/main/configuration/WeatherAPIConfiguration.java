package com.weather.api.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherAPIConfiguration {

    @Bean
    WeatherRequestAPIMapper weatherRequestAPIMapper() {
        return WeatherRequestAPIMapper.APIMapperBuilder.builder()
                .add("air-temperature", "https://api-open.data.gov.sg/v2/real-time/api/air-temperature")
                .add("rainfall", "https://api-open.data.gov.sg/v2/real-time/api/rainfall")
                .build();
    }
}
