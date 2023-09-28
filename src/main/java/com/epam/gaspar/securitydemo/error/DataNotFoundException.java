package com.epam.gaspar.securitydemo.error;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(long id) {
        super("Data with ID '" + id + "' not found!");
    }

}
