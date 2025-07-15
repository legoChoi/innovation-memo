package com.innovation.spring.entry.memo.lv03.dto.response;

import lombok.Builder;

@Builder
public record AuthSignInResponse(
        String accessToken
) {
}
