package kr.co.lotteon.controller;

import kr.co.lotteon.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/login")
    public String login(){
        return "/member/login";
    }

}
