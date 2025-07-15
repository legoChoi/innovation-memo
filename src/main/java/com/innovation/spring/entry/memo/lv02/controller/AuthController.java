package com.innovation.spring.entry.memo.lv02.controller;

import com.innovation.spring.entry.memo.lv02.dto.request.AuthSignInRequest;
import com.innovation.spring.entry.memo.lv02.dto.request.AuthSignUpRequest;
import com.innovation.spring.entry.memo.lv02.service.AuthService;
import com.innovation.spring.entry.memo.lv02.util.UriUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<Void> signIn(
            @RequestBody @Valid AuthSignInRequest authSignInRequest
    ) {
        authService.signIn(authSignInRequest);

        return ResponseEntity.ok()
                .build();
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(
            @RequestBody @Valid AuthSignUpRequest authSignUpRequest
    ) {
        authService.signUp(authSignUpRequest);

        return ResponseEntity.created(UriUtil.getSignInUri())
                .build();
    }
}
