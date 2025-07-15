package com.innovation.spring.entry.memo.lv03.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {
    ALREADY_REGISTERED_USER_EMAIL(HttpStatus.CONFLICT, "이미 가입된 이메일입니다."),
    EMAIL_USER_NOT_FOUND(HttpStatus.UNAUTHORIZED, "사용자를 찾을 수 없습니다."),
    PASSWORD_MISMATCH(HttpStatus.UNAUTHORIZED, "잘못된 비밀번호입니다.")
    ;

    private final HttpStatus status;
    private final String message;
}
