package com.games.bff.exceptions;

import com.games.bff.dtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomFeignException.class)
    public ResponseEntity<ErrorResponse> handleCustomFeignException(CustomFeignException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getStatus()));
    }
}

