package com.example.hybridweather.service;

import com.example.hybridweather.exception.ApiServerException;
import com.example.hybridweather.model.ApiResponseObject;
import com.example.hybridweather.model.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ApiServiceImpl implements ApiService {

    @Value("${openweathermap.api-id}")
    private String appId;
    @Value("${openweathermap.api-uri}")
    private String apiURI;
    private String units;

    private final RestTemplate restTemplate;
    private static Map<City.CountryCode, String> cityNames;

    public ApiServiceImpl(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        cityNames = new HashMap<>();
        cityNames.put(City.CountryCode.COUNTRY3, "Rotterdam");
        cityNames.put(City.CountryCode.COUNTRY2, "Riga");
        cityNames.put(City.CountryCode.COUNTRY1, "Novi Sad");
        this.units = "metric";
    }

    @Override
    public List<ApiResponseObject> fetchData() {
        List<ApiResponseObject> result = new ArrayList<>();
        log.info("GET Fetching data from openweathermap API");
        for (City.CountryCode c : City.CountryCode.values()) {
            // TODO Use a DTO!
            ApiResponseObject res = restTemplate.
                    getForObject(apiURI + "?q=" + cityNames.get(c) + "," + c + "&units="
                            + units + "&appid=" + this.appId, ApiResponseObject.class);
            result.add(res);
        }
        if (result.size() > 0)
            return result;
        else
            throw new ApiServerException("Api server not working");
    }
}
