package com.example.Challenge.infrastructure.exception.Rol;


import com.example.Challenge.infrastructure.entryEndpoint.RolController;
//import com.example.Challenge.infrastructure.entryEndpoint.RolController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

//@RestControllerAdvice
@RestControllerAdvice(assignableTypes = RolController.class)
@Component("rolGlobalExceptionHandler")
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<ValidationErrorResponse> handleValidationErrors(
       MethodArgumentNotValidException ex
    ){

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toList();

        ValidationErrorResponse response = new ValidationErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Error de validación",
                errors
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);

    }

    @ExceptionHandler(RolNotFoundException.class)
    public ResponseEntity<ValidationErrorResponse> handleRolNotFound(RolNotFoundException ex){

        ValidationErrorResponse response = new ValidationErrorResponse(
             HttpStatus.NOT_FOUND.value(),
             "Recurso no encontrado",
             List.of(ex.getMessage())
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);

    }

    public record ValidationErrorResponse(
        int status,
        String message,
        List<String> errors
    ){

    }



}
