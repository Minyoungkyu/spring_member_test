package com.member.member_test.repository;


import com.member.member_test.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    Long doJoin(Member member);

    Optional<Member> getMemberByLogin(String loginId, String loginPw);

}
