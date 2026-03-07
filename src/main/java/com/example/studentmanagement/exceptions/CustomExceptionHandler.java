package com.example.studentmanagement.exceptions;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<GeneralResponse<List<CustomErrorResponse>>> handle(NoSuchElementException e) {
        return handle(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<GeneralResponse<List<CustomErrorResponse>>> handle(HttpMessageNotReadableException e) {
        if (e.getCause() instanceof DateTimeParseException) {
            return handle("يجب ان يكون التاريخ بتنسيق yyyy-MM-dd مثل 2024-02-12", HttpStatus.BAD_REQUEST);
        }
        return handle(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GeneralResponse<List<CustomErrorResponse>>> handle(MethodArgumentNotValidException e) {
        return handle(
                e.getAllErrors()
                        .stream()
                        .map(err -> new CustomErrorResponse(err.getDefaultMessage()))
                        .toList(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralResponse<List<CustomErrorResponse>>> handle(Exception e) {
        return handle(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<GeneralResponse<List<CustomErrorResponse>>> handle(String message, HttpStatus code) {
        return handle(List.of(new CustomErrorResponse(message)), code);
    }

    private ResponseEntity<GeneralResponse<List<CustomErrorResponse>>> handle(List<CustomErrorResponse> errors,
            HttpStatus code) {
        return GeneralResponse.toResponseEntity(errors, code);
    }
}
