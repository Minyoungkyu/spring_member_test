package com.member.member_test.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {

    private String loginId;
    private String loginPw;
    private String confirmLoginPw;
    private String email;
    private String check;

}
