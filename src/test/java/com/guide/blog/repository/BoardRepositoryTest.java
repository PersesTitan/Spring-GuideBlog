package com.guide.blog.repository;

import com.guide.blog.domain.Board;
import com.guide.blog.domain.Member;
import com.guide.blog.service.BoardService;
import com.guide.blog.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class BoardRepositoryTest {

    @Autowired BoardRepository boardRepository;
    @Autowired BoardService boardService;
    @Autowired MemberService memberService;

    @Test
    public void 삭제_테스트() {
        //given
        Member member = Member.createMember("A", "A", "1234", null);
        Board board1 = Board.createBoard(member, "A", "A");
        Board board2 = Board.createBoard(member, "B", "B");
        Board board3 = Board.createBoard(member, "C", "C");

        //when
        memberService.join(member);
        boardService.saveBoard(board1);
        boardService.saveBoard(board2);
        boardService.saveBoard(board3);
        System.out.println("=====삭제전=====");
        select();

        //then
        boardRepository.deleteBoard(board2);
        System.out.println("=====삭제후=====");
        select();
    }

    //board 출력
    private void select() {
        List<Board> list = boardService.findAll();
        list.forEach(board -> {
            Long id = board.getId();
            String title = board.getTitle();
            String content = board.getContent();
            System.out.printf("아이디: %d 제목: %s 내용: %s%n", id, title, content);
        });
    }
}