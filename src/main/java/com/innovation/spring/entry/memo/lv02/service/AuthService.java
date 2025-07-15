package com.innovation.spring.entry.memo.lv02.service;

import com.innovation.spring.entry.memo.lv02.dto.request.AuthSignInRequest;
import com.innovation.spring.entry.memo.lv02.dto.request.AuthSignUpRequest;
import com.innovation.spring.entry.memo.lv02.entity.User;
import com.innovation.spring.entry.memo.lv02.exception.CustomRuntimeException;
import com.innovation.spring.entry.memo.lv02.exception.ExceptionMessage;
import com.innovation.spring.entry.memo.lv02.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signIn(AuthSignInRequest authSignInRequest) {
        User user = userRepository.findByEmail(authSignInRequest.email())
                .orElseThrow(() -> new CustomRuntimeException(ExceptionMessage.EMAIL_USER_NOT_FOUND));

        if (!passwordEncoder.matches(authSignInRequest.password(), user.getPassword())) {
            throw new CustomRuntimeException(ExceptionMessage.PASSWORD_MISMATCH);
        }

        // access token 반환
    }

    public void signUp(AuthSignUpRequest authSignUpRequest) {
        if (userRepository.existsByEmail(authSignUpRequest.email())) {
            throw new CustomRuntimeException(ExceptionMessage.ALREADY_REGISTERED_USER_EMAIL);
        }

        String encodedPassword = passwordEncoder.encode(authSignUpRequest.password());

        User user = User.builder()
                .email(authSignUpRequest.email())
                .password(encodedPassword)
                .build();

        userRepository.save(user);

        // access token 반환
    }
}
