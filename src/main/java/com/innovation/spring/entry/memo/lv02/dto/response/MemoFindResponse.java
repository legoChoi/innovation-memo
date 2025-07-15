package com.innovation.spring.entry.memo.lv02.dto.response;

import java.time.LocalDateTime;

public record MemoFindResponse(
        Long memoId,
        String title,
        String contents,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static MemoFindResponse of(Long memoId, String title, String contents, LocalDateTime createdA, LocalDateTime updatedA) {
        return new MemoFindResponse(memoId, title, contents, createdA, updatedA);
    }
}
