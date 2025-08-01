package com.innovation.spring.entry.memo.lv03.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomRuntimeException extends RuntimeException {

    private final HttpStatus status;
    private final String message;

    public CustomRuntimeException(ExceptionMessage exception) {
        super(exception.getMessage());
        this.status = exception.getStatus();
        this.message = exception.getMessage();
    }
}
