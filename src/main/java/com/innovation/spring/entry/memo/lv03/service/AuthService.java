package com.innovation.spring.entry.memo.lv03.service;

import com.innovation.spring.entry.memo.lv03.dto.request.AuthSignInRequest;
import com.innovation.spring.entry.memo.lv03.dto.request.AuthSignUpRequest;
import com.innovation.spring.entry.memo.lv03.dto.response.AuthSignInResponse;
import com.innovation.spring.entry.memo.lv03.dto.response.AuthSignUpResponse;
import com.innovation.spring.entry.memo.lv03.entity.User;
import com.innovation.spring.entry.memo.lv03.exception.CustomRuntimeException;
import com.innovation.spring.entry.memo.lv03.exception.ExceptionMessage;
import com.innovation.spring.entry.memo.lv03.repository.UserRepository;
import com.innovation.spring.entry.memo.lv03.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthSignInResponse signIn(AuthSignInRequest authSignInRequest) {
        // 로그인하려는 이메일로 유저 정보 조회
        User user = userRepository.findByEmail(authSignInRequest.email())
                .orElseThrow(() -> new CustomRuntimeException(ExceptionMessage.EMAIL_USER_NOT_FOUND));

        // 입력한 비밀번호 평문과 유저 정보에 저장된 암호화된 비밀번호 비교
        if (!passwordEncoder.matches(authSignInRequest.password(), user.getPassword())) {
            throw new CustomRuntimeException(ExceptionMessage.PASSWORD_MISMATCH);
        }

        // AccessToken 발급
        String accessToken = jwtProvider.generateAccessToken(user.getId());

        return AuthSignInResponse.builder()
                .accessToken(accessToken)
                .build();
    }

    @Transactional
    public AuthSignUpResponse signUp(AuthSignUpRequest authSignUpRequest) {
        // 동일 이메일 조회
        if (userRepository.existsByEmail(authSignUpRequest.email())) {
            throw new CustomRuntimeException(ExceptionMessage.ALREADY_REGISTERED_USER_EMAIL);
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(authSignUpRequest.password());

        // 유저 정보 저장
        User user = User.builder()
                .email(authSignUpRequest.email())
                .password(encodedPassword)
                .build();

        userRepository.save(user);

        // AccessToken 발급
        String accessToken = jwtProvider.generateAccessToken(user.getId());

        return AuthSignUpResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}
