package com.example.hybridweather.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Temperature {
    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;
    private Integer humidity;
    private Integer pressure;
}
