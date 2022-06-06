package com.guide.blog.repository;

import com.guide.blog.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    /**
     * 저장
     * @param member 정보 가져옴
     * @return 아이디 반환
     */
    public void save(Member member) {
        em.persist(member);
    }

    public Long findId(String loginId, String password) {
        return em.createQuery("SELECT M FROM Member M WHERE M.loginId = :loginId AND M.password = :password", Member.class)
                .setParameter("loginId", loginId)
                .setParameter("password", password)
                .getSingleResult()
                .getId();
    }

    /**
     * 아이디 조회
     * @param id 아이디 받아오기
     * @return 조회된 아이디 반환
     */
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("SELECT Member FROM Member", Member.class)
                .getResultList();
    }

    public List<Member> findByName(Long id) {
        return em.createQuery("SELECT M FROM Member AS M WHERE M.id = :id", Member.class)
                .setParameter("id", id)
                .getResultList();
    }

}
