package com.guide.blog.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * id - 유저 고유 아이디 <br>
 * userName - 유저 고유 이름 <br>
 * password - 유저 비밀번호 <br>
 * date - 계정 생성일 <br>
 * group - 유저 소속 <br>
 * information - 유저 정보
 */
@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Setter @NotNull
    private String nickname;
    @Setter @NotNull
    private String password;
    @NotNull
    private String loginId;
    @NotNull
    private LocalDateTime createDate;

    @Setter
    private String email;

    private Member(String nickname, String loginId, String password, String email) {
        this.nickname = nickname;
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.createDate = LocalDateTime.now();
    }

    //생성 로직
    public static Member createMember(String nickname, String loginId, String password, String email) {
        return new Member(nickname, loginId, password, email);
    }
}