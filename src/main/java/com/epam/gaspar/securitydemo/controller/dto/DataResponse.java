package com.epam.gaspar.securitydemo.controller.dto;

import java.time.Instant;

public record DataResponse(
        Long id,
        String key,
        String value,
        Instant createTimestamp
) {
}
