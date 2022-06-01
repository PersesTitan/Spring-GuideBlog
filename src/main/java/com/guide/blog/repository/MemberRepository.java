package com.guide.blog.repository;

import com.guide.blog.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    /**
     * 저장
     * @param member 정보 가져옴
     * @return 아이디 반환
     */
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    /**
     * 아이디 조회
     * @param id 아이디 받아오기
     * @return 조회된 아이디 반환
     */
    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
