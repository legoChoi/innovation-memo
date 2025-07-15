package com.innovation.spring.entry.memo.lv02.dto.response;

import com.innovation.spring.entry.memo.lv02.entity.Memo;

import java.util.List;

public record MemosFindResponse(
        List<MemoFindResponse> memos
) {

    public static MemosFindResponse of(List<Memo> memos) {
        List<MemoFindResponse> memoList = memos.stream()
                .map(m -> MemoFindResponse.of(
                        m.getId(),
                        m.getTitle(),
                        m.getContents(),
                        m.getCreatedAt(),
                        m.getUpdatedAt())
                )
                .toList();

        return new MemosFindResponse(memoList);
    }
}
