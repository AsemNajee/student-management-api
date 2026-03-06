package com.example.studentmanagement.exceptions;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<GeneralResponse<List<CustomErrorResponse>>> handle(NoSuchElementException e) {
        return handle(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralResponse<List<CustomErrorResponse>>> handle(Exception e){
        return handle(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    private ResponseEntity<GeneralResponse<List<CustomErrorResponse>>> handle(String message, HttpStatus code){
        return handle(List.of(new CustomErrorResponse(message)), code);
    }
    private ResponseEntity<GeneralResponse<List<CustomErrorResponse>>> handle(List<CustomErrorResponse> errors, HttpStatus code){
        return GeneralResponse.toResponseEntity(errors, code);
    }
}
