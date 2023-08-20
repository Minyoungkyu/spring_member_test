package com.member.member_test.controller;

import com.member.member_test.domain.Member;
import com.member.member_test.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String creaate(MemberForm form) {

        if(!form.getLoginPw().equals(form.getConfirmLoginPw())) {
            throw new RuntimeException("비밀번호 더블체크에서 예외발생!");
        }

        Member member = new Member(form.getLoginId(), form.getLoginPw(), form.getEmail(), form.getCheck());

        memberService.doJoin(member);

        return "redirect:/";
    }

    @PostMapping("/")
    @ResponseBody
    public String login(HttpSession httpSession, LoginForm form) {

        Member member = memberService.getMemberByLogin(form.getUserLoginId(), form.getUserLoginPw());

        if(member == null) return "아이디 또는 비밀번호가 일치하지 않습니다.";

        httpSession.setAttribute("loginedMemberId", member.getId());

        return "로그인 성공!";
    }




}
