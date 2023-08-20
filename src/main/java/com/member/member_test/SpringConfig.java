package com.member.member_test;


import com.member.member_test.domain.Member;
import com.member.member_test.repository.ArticleRepository;
import com.member.member_test.repository.JpaArticleRepository;
import com.member.member_test.repository.JpaMemberRepository;
import com.member.member_test.repository.MemberRepository;
import com.member.member_test.service.ArticleService;
import com.member.member_test.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }

    @Bean
    public ArticleService articleService() {
        return new ArticleService(articleRepository());
    }

    @Bean
    public ArticleRepository articleRepository() {
        return new JpaArticleRepository(em);
    }
}
