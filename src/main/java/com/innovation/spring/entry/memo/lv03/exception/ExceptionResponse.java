package com.innovation.spring.entry.memo.lv03.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ExceptionResponse(
        HttpStatus status,
        String message
) {
}
