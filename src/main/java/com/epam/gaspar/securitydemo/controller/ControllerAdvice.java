package com.epam.gaspar.securitydemo.controller;

import com.epam.gaspar.securitydemo.controller.dto.ErrorResponse;
import com.epam.gaspar.securitydemo.error.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DataNotFoundException.class)
    public ErrorResponse handleNotFound(DataNotFoundException e) {
        return new ErrorResponse(e.getClass().getSimpleName(), e.getMessage());
    }

}
