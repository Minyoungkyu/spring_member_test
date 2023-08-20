package com.member.member_test.controller;

import com.member.member_test.domain.Article;
import com.member.member_test.service.ArticleService;
import com.querydsl.core.Tuple;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles/write")
    public String createWriteForm() {
        return "articles/write";
    }

    @PostMapping("/articles/write")
    public String doArticleWrite(ArticleForm articleForm, HttpSession httpSession) {

        Long loginedUserId = (Long)httpSession.getAttribute("loginedMemberId");

        Article article = new Article(loginedUserId, articleForm.getTitle(), articleForm.getBody());

        articleService.doWrite(article);

        return"redirect:/";
    }

    @GetMapping("/articles/getArticle")
    @ResponseBody
    public Article getArticle(Long id) {

        return articleService.getArticleById(id);
    }
}
