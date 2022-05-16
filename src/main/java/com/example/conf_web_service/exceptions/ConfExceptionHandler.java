package com.example.conf_web_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ConfExceptionHandler {

    @ExceptionHandler(value = {ConfException.class})
    public ResponseEntity<Object> handleConfException(ConfException e) {
        ConfExceptionModel exception = new ConfExceptionModel(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
