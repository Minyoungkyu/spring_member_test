package com.member.member_test.repository;

import com.member.member_test.domain.Member;
import com.member.member_test.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;
    private final JPAQueryFactory query;
    private final QMember qmember;

    @Autowired
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
        this.qmember = QMember.member;
    }

    @Override
    public Long doJoin(Member member) {
        em.persist(member);
        return member.getId();
    }

    @Override
    public Optional<Member> getMemberByLogin(String loginId, String loginPw) {
        return query
                .selectFrom(qmember)
                .where(qmember.loginId.eq(loginId),
                        qmember.loginPw.eq(loginPw))
                .stream().findAny();
    }
}
