package com.guide.blog.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

/**
 *
 */
@Entity
@Getter
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @NotNull private String title;
    @NotNull private String content;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime createdDate;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Board(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.createdDate = LocalDateTime.now();
    }

    protected Board() {}
}
