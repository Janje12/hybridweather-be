package com.example.hybridweather.service;

import com.example.hybridweather.model.ApiResponseObject;

import java.util.List;

public interface ApiService {

    List<ApiResponseObject> fetchData();
}
