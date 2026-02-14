package com.weather.api.main.weatherrequest;

import java.time.LocalDateTime;

import org.springframework.web.client.RestClient;

import com.weather.api.main.entities.WeatherAPIResponse;

public class WeatherRequest {
    private RestClient restClient;

    public WeatherRequest(String url) {
        this.restClient = RestClient.builder()
                .baseUrl(url)
                .build();
    }

    public String getReadingsInText() {
        return this.restClient.get().retrieve().body(String.class);
    }

    public WeatherAPIResponse getReadindgsWithDate(String dateTime) {
        return this.restClient.get().uri((uriBuilder) -> uriBuilder.queryParam("date", dateTime).build())
                .retrieve().body(WeatherAPIResponse.class);
    }

    public WeatherAPIResponse getReadings() {
        return this.restClient.get().retrieve().body(WeatherAPIResponse.class);
    }

}
