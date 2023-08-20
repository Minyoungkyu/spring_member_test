package com.member.member_test.service;


import com.member.member_test.domain.Article;
import com.member.member_test.repository.ArticleRepository;
import com.querydsl.core.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void doWrite(Article article) {
        articleRepository.doArticleWrtie(article);
    }

    public Article getArticleById(Long id) {
        return articleRepository.getArticleById(id).get();
    }
}
