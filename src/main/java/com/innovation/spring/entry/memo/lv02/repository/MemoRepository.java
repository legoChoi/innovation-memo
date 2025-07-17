package com.innovation.spring.entry.memo.lv02.repository;

import com.innovation.spring.entry.memo.lv02.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    @Query("select m from Memo m where m.contents like concat('%', :keyword, '%') order by m.updatedAt desc")
    List<Memo> getMemosByKeyword(String keyword);

    List<Memo> findMemosByContentsContainsOrderByUpdatedAtDesc(String keyword);
}
