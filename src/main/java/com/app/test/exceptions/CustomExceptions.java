package com.app.test.exceptions;

import org.springframework.http.HttpStatus;

public class CustomExceptions extends RuntimeException{
    private String messageTech;
    private HttpStatus httpStatus;

    public CustomExceptions(String message, String messageTech, HttpStatus httpStatus) {
        super(message);
        this.messageTech = messageTech;
        this.httpStatus = httpStatus;
    }
}
