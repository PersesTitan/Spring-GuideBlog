package com.guide.blog.controller;

import com.guide.blog.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    //로그인 유저이름 받아오기
    @GetMapping("/")
    public String login(Model model, Member member) {
        String userName = member.getNickname();
        model.addAttribute("userName", userName);
        return userName;
    }

//    @GetMapping("")
//    public String login
}
