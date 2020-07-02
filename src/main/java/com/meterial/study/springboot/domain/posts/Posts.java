package com.meterial.study.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor  //기본생성자 자동추가
@Entity
public class Posts {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙 =>GenerationType.IDENTITY 사용시  auto Increase 가능.
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
