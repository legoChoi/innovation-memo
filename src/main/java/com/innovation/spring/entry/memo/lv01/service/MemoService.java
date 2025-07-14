package com.innovation.spring.entry.memo.lv01.service;

import com.innovation.spring.entry.memo.lv01.dto.response.MemosFindResponse;
import com.innovation.spring.entry.memo.lv01.entity.Memo;
import com.innovation.spring.entry.memo.lv01.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    public MemosFindResponse getMemosByKeyword(String keyword) {
        System.out.println("keyword = " + keyword);
        List<Memo> memos = memoRepository.getMemosByKeyword(keyword);

        return MemosFindResponse.of(memos);
    }
}
