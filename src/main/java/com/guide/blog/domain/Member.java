package com.guide.blog.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * <p>
 * id - 해당 전용 아이디
 * PK 정의, AUTO 정의 <br>
 * </p>
 *
 * name - 아이디 이름 <br>
 * password - 비밀번호 <br>
 * date - 아이디를 생성한 날짜 <br>
 * email - 이메일 <br>
 */
@Data
@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String userName;
    private String password;

    private LocalDate date;
    private String email;
}
