package com.example.hybridweather.exception;

import java.io.Serializable;

public class ApiServerException extends RuntimeException implements Serializable {

    public ApiServerException(String message) {
        super(message);
    }
}
