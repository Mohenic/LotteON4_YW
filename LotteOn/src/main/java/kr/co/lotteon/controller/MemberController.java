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

    @GetMapping("/member/join")
    public String join(){
        return "/member/join";
    }

    @GetMapping("/member/register")
    public String register(){
        return "/member/register";
    }
    @GetMapping("/member/registerSeller")
    public String registerSeller(){
        return "/member/registerSeller";
    }
    @GetMapping("/member/signup")
    public String signup(){
        return "/member/signup";
    }

}
