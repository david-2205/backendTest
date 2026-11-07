package com.example.Challenge.infrastructure.exception.User;

import com.example.Challenge.infrastructure.entryEndpoint.UserController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

//@RestControllerAdvice(value = "com.example.Challenge.infrastructure.exception.User")
/*@RestControllerAdvice(basePackages = "com.example.Challenge.infrastructure.entryEndpoint.exception.User")
@Component("userGlobalExceptionHandler")*/
@RestControllerAdvice(assignableTypes = UserController.class)
@Component("userGlobalExceptionHandler")
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex){
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

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExists(UserAlreadyExistsException ex) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }

    public record ValidationErrorResponse(
            int status,
            String message,
            List<String> errors
    ){

    }

}
