package com.example.hybridweather.service;

import com.example.hybridweather.model.ApiResponseObject;
import com.example.hybridweather.model.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityServiceImpl implements CityService {

    private static Map<Long, City> cities = null;
    private final ApiService apiService;

    public CityServiceImpl(final ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<City> getCities() {
        if (cities == null) {
            List<ApiResponseObject> apiResponses = apiService.fetchData();
            cities = new HashMap<>();
            for (ApiResponseObject a : apiResponses) {
                if (Integer.parseInt(a.getCod()) >= 400)
                    continue;
                cities.put(a.getCity().getId(), a.getCity());
            }
        }
        return new ArrayList<>(cities.values());
    }
}
