package com.guide.blog.service;

import com.guide.blog.domain.Member;
import com.guide.blog.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() {
        //given
        Member member = new Member("A", "a", "1234", null);

        //when
        Long id = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(id));
    }

    @Test
    public void 중복_예외_처리() {
        //given
        Member member1 = new Member("A", "b", "1234", null);
        Member member2 = new Member("A", "a", "1234", null);
        Member member3 = new Member("B", "b", "1234", null);

        //when
        memberService.join(member1);
        try {
            //nickname 중복 에러
            memberService.join(member2);
        } catch (IllegalStateException e) {
            log.error("{}", e.getMessage());
            return;
        }

        try {
            //loginId 중복 에러
            memberService.join(member3);
        } catch (IllegalStateException e) {
            log.error("{}", e.getMessage());
            return;
        }

        //then
        fail("경고 발생해야함");
    }
}