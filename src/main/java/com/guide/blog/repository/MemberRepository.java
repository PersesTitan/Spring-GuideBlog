package com.guide.blog.repository;

import com.guide.blog.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    /**
     * 저장
     * @param member 정보 가져옴
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

    /**
     * 중복 체크하는 메소드
     * @param loginId 로그인 아이디를 받았을때
     * @return 리스트를 반환함
     */
    public List<Member> findByLoginId(String loginId) {
        return em.createQuery("SELECT M FROM Member AS M WHERE M.loginId = :loginId", Member.class)
                .setParameter("loginId", loginId)
                .getResultList();
    }

    public List<Member> findByNickName(String nickName) {
        return em.createQuery("SELECT M FROM Member AS M WHERE M.nickname = :nickName", Member.class)
                .setParameter("nickName", nickName)
                .getResultList();
    }
}
