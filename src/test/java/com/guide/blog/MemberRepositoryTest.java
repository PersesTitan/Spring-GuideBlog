package com.guide.blog;

import com.guide.blog.domain.Member;
import com.guide.blog.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void repositoryTest() throws Exception {
        //데이터 여러개 넣기
        String[] names = {"TESTER1", "TESTER2", "TESTER3"};
        new ArrayList<>(List.of(names))
                .forEach(view -> {
                    //given
                    Member member = new Member(view, view, "1234", null);
                    //when
                    Long saveId = memberRepository.save(member);
                    Member findMember = memberRepository.find(saveId);
                    //then
                    Assertions.assertThat(member).isEqualTo(findMember);
                    System.out.println(member);
                });
    }
}
