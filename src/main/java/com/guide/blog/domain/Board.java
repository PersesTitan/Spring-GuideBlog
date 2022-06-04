package com.guide.blog.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

/**
 *
 */
@Entity
@Getter @Setter
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;
    private String content;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime createdDate;
}
