package com.guide.blog.service;

import com.guide.blog.domain.Member;
import com.guide.blog.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    //@AutoWire 생략 가능
    private final MemberRepository memberRepository;

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        String loginId = member.getLoginId();
        String nickname = member.getNickname();
        List<Member> loginIdList = memberRepository.findByLoginId(loginId);
        if (!loginIdList.isEmpty()) throw new IllegalStateException("존재하는 아이디 입니다.");
        List<Member> nickName = memberRepository.findByNickName(nickname);
        if (!nickName.isEmpty()) throw new IllegalStateException("존재하는 닉네임 입니다.");
    }
}
