package com.innovation.spring.entry.memo.lv02.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {
    ALREADY_REGISTERED_USER_EMAIL(HttpStatus.CONFLICT, "이미 가입된 이메일입니다."),
    ;

    private final HttpStatus status;
    private final String message;
}
