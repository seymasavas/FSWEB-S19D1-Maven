package com.workintech.s18d2.exception;

import org.springframework.http.HttpStatus;



public class PlantErrorResponse {
    private String message;
    private HttpStatus status;

    public PlantErrorResponse (String message, HttpStatus status){
        this.message=message;
        this.status=status;

    }
}
