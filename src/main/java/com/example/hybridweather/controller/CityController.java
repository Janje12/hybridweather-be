package com.example.hybridweather.controller;

import com.example.hybridweather.model.City;
import com.example.hybridweather.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/cities", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

    private final CityService cityService;

    public CityController(final CityService cityService) {
        this.cityService = cityService;
    }

    @CrossOrigin
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Object getAllCities() {
        log.info("GET all cities");
        List<City> cities = cityService.getCities();
        return cities;
    }
}
