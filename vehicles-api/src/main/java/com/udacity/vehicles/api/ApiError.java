package com.udacity.vehicles.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Represents an API error response.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private final String message;
    private final List<String> errors;

    public ApiError(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }
}
