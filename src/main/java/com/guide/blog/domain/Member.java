package com.guide.blog.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * id - 해당 전용 아이디 <br>
 * name - 아이디 이름 <br>
 * password - 비밀번호 <br>
 * date - 아이디를 생성한 날짜 <br>
 * email - 이메일
 */
@Data
public class Member {
    @NotNull long id;
    @NotBlank String name;
    @NotBlank String password;
    @NotBlank Date date;
    String email;
}
