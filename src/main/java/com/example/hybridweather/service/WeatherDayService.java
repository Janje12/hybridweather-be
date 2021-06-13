package com.example.hybridweather.service;

import com.example.hybridweather.model.WeatherDay;

import java.util.List;
import java.util.Map;

public interface WeatherDayService {

    Map<Long, List<WeatherDay>> getWeatherDays(Map<String, String> queryParams);
    Map<Integer, Long> getTemperatureAverage(Map<String, String> queryParams);
}
