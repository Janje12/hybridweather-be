package com.example.hybridweather.controller;

import com.example.hybridweather.model.WeatherDay;
import com.example.hybridweather.service.WeatherDayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping(value = "/api/weather", produces = MediaType.APPLICATION_JSON_VALUE)
public class WeatherController {

    private final WeatherDayService weatherDayService;

    public WeatherController(final WeatherDayService weatherDayService) {
        this.weatherDayService = weatherDayService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<Long, List<WeatherDay>> getWeather(@RequestParam(required = false) Map<String, String> queryParams) {
        log.info("GET getting all weather data for cities");
        Map<Long, List<WeatherDay>> weatherDays = weatherDayService.getWeatherDays(queryParams);
        return weatherDays;
    }

    // TODO Add Spring Security and add CORS settings for only current site in use
    @CrossOrigin
    @GetMapping("average")
    @ResponseStatus(HttpStatus.OK)
    public Map<Integer, Long> getTemperatureAverage(@RequestParam(required = false) Map<String, String> queryParams) {
        log.info("GET getting avg temp for cities");
        Map<Integer, Long> weatherDays = weatherDayService.getTemperatureAverage(queryParams);
        return weatherDays;
    }
}
