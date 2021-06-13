package com.example.hybridweather.model;

import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WeatherDay {

    enum PartOfDay {
        DAY("d"),
        NIGHT("n");

        private final String part;

        PartOfDay(String part) {
            this.part = part;
        }
    }

    private LocalDateTime dt;
    private String dt_txt;
    private Temperature main;
    private WeatherType[] weather;
    private Object clouds;
    private Object sys;

    public void setDt(Long dt) {
        this.dt = LocalDateTime.ofInstant(Instant.ofEpochSecond(dt),
                TimeZone.getDefault().toZoneId());
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public void setMain(Temperature main) {
        this.main = main;
    }

    public void setWeather(WeatherType[] weather) {
        this.weather = weather;
    }

    public void setClouds(Object clouds) {
        this.clouds = clouds;
    }

    public void setSys(Object sys) {
        this.sys = sys;
    }
}
