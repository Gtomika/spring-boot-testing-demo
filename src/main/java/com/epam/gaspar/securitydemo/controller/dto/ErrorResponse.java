package com.epam.gaspar.securitydemo.controller.dto;

public record ErrorResponse(
        String type,
        String message
) {
}
