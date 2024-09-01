package com.games.bff.exceptions;

public class CustomFeignException extends RuntimeException {
    private final int status;

    public CustomFeignException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return super.getMessage();
    }
}