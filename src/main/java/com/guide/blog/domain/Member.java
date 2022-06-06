package com.guide.blog.domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * id - 유저 고유 아이디 <br>
 * userName - 유저 고유 이름 <br>
 * password - 유저 비밀번호 <br>
 * date - 계정 생성일 <br>
 * group - 유저 소속 <br>
 * information - 유저 정보
 */
@Entity @Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotNull private String nickname;
    @NotNull private String loginId;
    @NotNull private String password;
    @NotNull private LocalDateTime createDate;

    private String email;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Member(String nickname, String loginId, String password, String email) {
        this.nickname = nickname;
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.createDate = LocalDateTime.now();
    }

    protected Member() {}
}