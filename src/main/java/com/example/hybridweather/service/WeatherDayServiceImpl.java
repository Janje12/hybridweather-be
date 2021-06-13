package com.example.hybridweather.service;

import com.example.hybridweather.model.ApiResponseObject;
import com.example.hybridweather.model.WeatherDay;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class WeatherDayServiceImpl implements WeatherDayService {

    private static Map<Long, List<WeatherDay>> weatherData = null;
    private final ApiService apiService;

    public WeatherDayServiceImpl(final ApiService apiService) {
        this.apiService = apiService;
    }

    private Map<Long, List<WeatherDay>> getWeatherData() {
        if (weatherData == null) {
            List<ApiResponseObject> data = apiService.fetchData();
            weatherData = new HashMap<>();
            for (ApiResponseObject a : data) {
                if (Integer.parseInt(a.getCod()) >= 400)
                    continue;
                weatherData.put(a.getCity().getId(), Arrays.asList(a.getList()));
            }
        }
        return weatherData;
    }

    @Override
    public Map<Long, List<WeatherDay>> getWeatherDays(Map<String, String> queryParams) {
        return this.getWeatherData();
    }

    @Override
    public Map<Integer, Long> getTemperatureAverage(Map<String, String> queryParams) {
        Map<Long, List<WeatherDay>> result = null;
        if (queryParams.size() > 0)
            result = this.consumeParams(queryParams);
        else
            result = getWeatherData();
        SortedMap<Integer, Long> averageTemp = new TreeMap<>();
        if (queryParams.get("sort") != null && queryParams.get("sort").equalsIgnoreCase("dsc")) {
            averageTemp = new TreeMap<>(Collections.reverseOrder());
        }
        // TODO Turn into stream!
        for (Map.Entry<Long, List<WeatherDay>> e : result.entrySet()) {
            List<WeatherDay> tmp = e.getValue();
            Double avgTmp = tmp.stream().mapToDouble(x -> x.getMain().getTemp()).average().getAsDouble();
            averageTemp.put(avgTmp.intValue(), e.getKey());
        }
        return averageTemp;
    }

    private Map<Long, List<WeatherDay>> consumeParams(Map<String, String> queryParams) {
        Map<Long, List<WeatherDay>> result = getWeatherData();
        if (queryParams.get("cities") != null) {
            String[] cities = queryParams.get("cities").split(",");
            if (cities.length < result.size()) {
                Map<Long, List<WeatherDay>> tmp = new HashMap<>();
                for (String id : cities)
                    tmp.put(Long.parseLong(id.trim()), result.get(Long.parseLong(id.trim())));
                result = tmp;
            }
        }
        if (queryParams.get("from") != null && queryParams.get("to") != null) {
            LocalDateTime from = LocalDateTime.parse(queryParams.get("from"));
            LocalDateTime to = LocalDateTime.parse(queryParams.get("to"));
            Map<Long, List<WeatherDay>> tmp = new HashMap<>();
            for (Map.Entry<Long, List<WeatherDay>> e : result.entrySet()) {
                List<WeatherDay> datesBetween = e.getValue().stream().filter(x ->
                        to.compareTo(x.getDt()) >= 0 && from.compareTo(x.getDt()) < 0).collect(Collectors.toList());
                tmp.put(e.getKey(), datesBetween);
            }
            result = tmp;
        }
        return result;
    }

}
