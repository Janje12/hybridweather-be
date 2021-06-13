package com.example.hybridweather.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class WeatherType {
    private Integer id;
    // Would be ENUM if I know all of them doesn't say on API docs
    private String main;
    private String description;
    private String icon;
}
