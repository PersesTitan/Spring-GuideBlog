package com.guide.blog.service;

import com.guide.blog.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    
}
