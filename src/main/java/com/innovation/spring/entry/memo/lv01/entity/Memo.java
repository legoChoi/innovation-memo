package com.innovation.spring.entry.memo.lv01.entity;

import com.innovation.spring.entry.memo.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "memos")

@Getter
public class Memo extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String contents;
}
