package com.weather.api.main.weatherrequest;

import org.springframework.web.client.RestClient;

public class WeatherRequest {
    private RestClient restClient;

    public WeatherRequest(String url) {
        this.restClient = RestClient.builder()
                .baseUrl(url)
                .build();
    }

    public String getReadings() {
        return this.restClient.get().retrieve().body(String.class);
    }

}
