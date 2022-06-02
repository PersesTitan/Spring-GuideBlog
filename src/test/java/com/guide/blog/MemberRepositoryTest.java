package com.guide.blog;

import com.guide.blog.domain.Member;
import com.guide.blog.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    void repositoryTest() throws Exception {
        //given
        createMember();

        //when

        //then
    }

    private void createMember() {
        String[] names = {"TESTER1", "TESTER2", "TESTER3"};
        new ArrayList<>(List.of(names))
                .forEach(view -> {
                    //given
                    Member member = new Member();
                    member.setUserName(view);
                    member.setPassword("1234");
                    member.setDate(LocalDate.now());
                    //when
                    Long saveId = memberRepository.save(member);
                    Member findMember = memberRepository.find(saveId);
                    //then
                    Assertions.assertThat(member).isEqualTo(findMember);
                });
    }
}
