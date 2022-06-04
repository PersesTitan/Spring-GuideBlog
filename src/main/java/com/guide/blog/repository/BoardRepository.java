package com.guide.blog.repository;

import com.guide.blog.domain.Board;
import com.guide.blog.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BoardRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Board board) {
        em.persist(board);
        return board.getId();
    }

    public Board find(Long id) {
        return em.find(Board.class, id);
    }
}
