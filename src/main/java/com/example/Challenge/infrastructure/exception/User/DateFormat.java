package com.example.Challenge.infrastructure.exception.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class DateFormat {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleInvalidFormatException(HttpMessageNotReadableException ex){

        Map<String, String> errorResponse = new HashMap<>();

        if (ex.getMessage() != null && ex.getMessage().contains("java.time.LocalDate")) {
            errorResponse.put("error", "El formato de fecha es requerido y debe ser YYYY-MM-DD");
        } else {
            errorResponse.put("error", "La petición JSON no es válida");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }

}
