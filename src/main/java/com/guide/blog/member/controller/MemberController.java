package com.guide.blog.member.controller;

import com.guide.blog.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    @RequestMapping("/member/insert")
    public String insert(Model model) {
        model.addAttribute("member", new Member());
        return "member/make";
    }
}
