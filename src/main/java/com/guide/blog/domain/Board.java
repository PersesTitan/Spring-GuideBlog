package com.guide.blog.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

/**
 * 게시글
 */
@Entity @Getter
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @NotNull @Setter
    private String title;
    @NotNull @Setter
    private String content;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime createdDate;

    private Board(Member member, String title, String content) {
        this.member = member;
        this.title = title;
        this.content = content;
        this.createdDate = LocalDateTime.now();
    }

    protected Board() {}

    //생성 메소드
    public static Board createBoard(Member member, String title, String content) {
        return new Board(member, title, content);
    }

}
