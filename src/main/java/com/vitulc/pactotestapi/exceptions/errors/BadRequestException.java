package com.vitulc.pactotestapi.exceptions.errors;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String errorMessage) {
        super(errorMessage);
    }
}
