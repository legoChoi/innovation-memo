package com.innovation.spring.entry.memo.lv03.controller;

import com.innovation.spring.entry.memo.lv03.dto.request.AuthSignInRequest;
import com.innovation.spring.entry.memo.lv03.dto.request.AuthSignUpRequest;
import com.innovation.spring.entry.memo.lv03.dto.response.AuthSignInResponse;
import com.innovation.spring.entry.memo.lv03.dto.response.AuthSignUpResponse;
import com.innovation.spring.entry.memo.lv03.service.AuthService;
import com.innovation.spring.entry.memo.lv03.util.UriUtil;
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
    public ResponseEntity<AuthSignInResponse> signIn(
            @RequestBody @Valid AuthSignInRequest authSignInRequest
    ) {
        AuthSignInResponse response = authService.signIn(authSignInRequest);

        return ResponseEntity.ok()
                .body(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthSignUpResponse> signUp(
            @RequestBody @Valid AuthSignUpRequest authSignUpRequest
    ) {
        AuthSignUpResponse response = authService.signUp(authSignUpRequest);

        return ResponseEntity.created(UriUtil.getSignInUri())
                .body(response);
    }
}
