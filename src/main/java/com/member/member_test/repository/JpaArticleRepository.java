package com.member.member_test.repository;


import com.member.member_test.domain.Article;
import com.member.member_test.domain.QArticle;
import com.member.member_test.domain.QMember;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class JpaArticleRepository implements ArticleRepository{

    private final EntityManager em;
    private final JPAQueryFactory query;
    private final QArticle qArticle;

    @Autowired
    public JpaArticleRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
        this.qArticle = QArticle.article;
    }

    @Override
    public Article doArticleWrtie(Article article) {
       em.persist(article);
       return article;
    }

    @Override
    public Optional<Article> getArticleById(Long id) {

        return em.createQuery("select a, m.loginId as loginId from Article a left join Member m on m.id=a.userId where a.id = :id", Article.class)
                .setParameter("id",id)
                .getResultList().stream().findAny();
    }

    @Override
    public List<Article> getArticles() {
        return null;
    }
}
