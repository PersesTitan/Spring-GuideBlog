package com.guide.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * id - 유저 고유 아이디
 * userName - 유저 고유 이름
 * password - 유저 비밀번호
 * date - 계정 생성일
 * group - 유저 소속
 * information - 유저 정보
 */
@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String nickname;
    private String loginId;
    private String password;
    private String email;
}