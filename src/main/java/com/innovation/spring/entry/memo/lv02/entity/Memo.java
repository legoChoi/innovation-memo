package com.innovation.spring.entry.memo.lv02.entity;

import com.innovation.spring.entry.memo.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "memos")

@Getter
public class Memo extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String contents;
}
