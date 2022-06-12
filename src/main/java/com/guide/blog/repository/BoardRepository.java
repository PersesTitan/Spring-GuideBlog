package com.guide.blog.repository;

import com.guide.blog.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public void save(Board board) {
        if (board.getId() == null) {
            em.persist(board);
        } else {
            em.merge(board);
        }
    }

    //조회 로직
    public Board findOne(Long id) {
        return em.find(Board.class, id);
    }

    public List<Board> findAll() {
        return em.createQuery("SELECT b FROM Board b", Board.class)
                .getResultList();
    }

    //삭제 로직
    public void boardDelete(Long id) {
        em.createQuery("DELETE FROM Board AS b WHERE b.id = :id")
                .setParameter("id", id);
    }
}
