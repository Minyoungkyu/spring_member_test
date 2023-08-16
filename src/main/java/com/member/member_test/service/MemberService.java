package com.member.member_test.service;

import com.member.member_test.domain.Member;
import com.member.member_test.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long doJoin(Member member) {
        return memberRepository.doJoin(member);
    }

    public Member getMemberByLogin(String userLoginId, String userLoginPw) {
        if(memberRepository.getMemberByLogin(userLoginId, userLoginPw).isEmpty()) {
            return null;
        }
        return memberRepository.getMemberByLogin(userLoginId, userLoginPw).get();
    }
}
