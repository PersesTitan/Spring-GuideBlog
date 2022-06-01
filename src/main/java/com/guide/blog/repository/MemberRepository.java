package com.guide.blog.repository;

import com.guide.blog.domain.Member;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(long id);

}
