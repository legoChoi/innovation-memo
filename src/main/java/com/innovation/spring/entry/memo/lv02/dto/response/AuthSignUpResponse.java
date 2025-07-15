package com.innovation.spring.entry.memo.lv02.dto.response;

import lombok.Builder;

@Builder
public record AuthSignUpResponse(
        String accessToken
) {
}
