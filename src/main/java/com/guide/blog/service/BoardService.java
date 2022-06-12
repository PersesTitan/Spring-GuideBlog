package com.guide.blog.service;

import com.guide.blog.domain.Board;
import com.guide.blog.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

    public Board findOne(Long id) {
        return boardRepository.findOne(id);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }
}
