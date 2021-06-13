package com.example.hybridweather.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiResponseObject {

    private String cod;
    private String message;
    private Integer cnt;
    private City city;
    private WeatherDay[] list;
}
