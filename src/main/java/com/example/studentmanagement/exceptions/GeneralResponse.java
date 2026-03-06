package com.example.studentmanagement.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralResponse<T> {
    private T data;
    private List<CustomErrorResponse> errors;
    private GeneralResponseStatus status;

    private GeneralResponse(T data, List<CustomErrorResponse> errors, HttpStatus code) {
        this.status = code.isError()
                ? GeneralResponseStatus.ERROR
                : GeneralResponseStatus.SUCCESS;
        this.data = data;
        this.errors = errors;
    }

    public GeneralResponse() {
        this.status = GeneralResponseStatus.SUCCESS;
    }

    public static <T> ResponseEntity<GeneralResponse<T>> toResponseEntity(T data, HttpStatus code) {
        var generalResponse = new GeneralResponse<>(data, null, code);
        return new ResponseEntity<>(generalResponse, code);
    }

    public static ResponseEntity<GeneralResponse<List<CustomErrorResponse>>> toResponseEntity(
            List<CustomErrorResponse> errors, HttpStatus code) {
        var generalResponse = new GeneralResponse<List<CustomErrorResponse>>(null, errors, code);
        return new ResponseEntity<>(generalResponse, code);
    }

    public static ResponseEntity<GeneralResponse<Void>> toResponseEntity(HttpStatus code) {
        return new ResponseEntity<GeneralResponse<Void>>(code);
    }

    private enum GeneralResponseStatus {
        SUCCESS, ERROR
    }
}
