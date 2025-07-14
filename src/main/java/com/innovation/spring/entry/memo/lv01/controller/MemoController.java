package com.innovation.spring.entry.memo.lv01.controller;

import com.innovation.spring.entry.memo.lv01.dto.response.MemosFindResponse;
import com.innovation.spring.entry.memo.lv01.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/memos")
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/contents")
    public ResponseEntity<MemosFindResponse> getMemosByKeyword(
            @RequestParam(required = false) String keyword
    ) {
        MemosFindResponse data = memoService.getMemosByKeyword(keyword);

        return ResponseEntity.ok()
                .body(data);
    }
}
