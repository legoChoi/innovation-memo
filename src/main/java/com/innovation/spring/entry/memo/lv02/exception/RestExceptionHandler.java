package com.innovation.spring.entry.memo.lv02.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CustomRuntimeException.class)
    public ResponseEntity<ExceptionResponse> handleCustomRuntimeException(CustomRuntimeException e) {
        ExceptionResponse response = ExceptionResponse.builder()
                .status(e.getStatus())
                .message(e.getMessage())
                .build();

        return createResponse(response);
    }

    private ResponseEntity<ExceptionResponse> createResponse(ExceptionResponse exceptionResponse) {
        return ResponseEntity
                .status(exceptionResponse.status())
                .body(exceptionResponse);
    }
}
