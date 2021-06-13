package com.example.hybridweather.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {

    public enum CountryCode {
        //  For all the country codes would use Locale.getISOCountries();
        COUNTRY1("RS"), COUNTRY2("LA"), COUNTRY3("NL");

        String countryCode;

        CountryCode(String countryCode) {
            this.countryCode = countryCode;
        }
    }

    private Long id;
    private String name;
    private String country;
    // Coordinates class for working with coordinates
    private Object coord;
    private Instant sunrise;
    private Instant sunset;
    private Integer timezone;
    //private WeatherDay[] weatherData;


}
