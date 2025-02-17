package com.example.truper.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dto.BadResponseDto;
import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<BadResponseDto> handle404() {
        return new ResponseEntity<>(
                new BadResponseDto("Bad Request",
                        new ArrayList<>(
                                Arrays.asList("No se encontro el contenido solicitado, favor de validar el ID"))),
                HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BadResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(objectError -> {
                    String fieldName = ((FieldError) objectError).getField();
                    String message = objectError.getDefaultMessage();
                    return fieldName + ": " + message;
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(
                new BadResponseDto("Bad Request",
                        errors),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<BadResponseDto> handleException() {
        return new ResponseEntity<>(
                new BadResponseDto("Internal Server Error",
                        new ArrayList<>(
                                Arrays.asList("Error del servidor, favor de contactar al administrador"))),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
