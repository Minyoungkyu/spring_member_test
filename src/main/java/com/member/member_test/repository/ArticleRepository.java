package com.member.member_test.repository;

import com.member.member_test.domain.Article;
import com.querydsl.core.Tuple;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {

    Article doArticleWrtie(Article article);

    Optional<Article> getArticleById(Long id);

    List<Article> getArticles();

}
