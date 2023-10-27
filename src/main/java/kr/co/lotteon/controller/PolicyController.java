package kr.co.lotteon.controller;

import kr.co.lotteon.entity.MemberTermsEntity;
import kr.co.lotteon.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PolicyController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/policy/terms")
    public String termsMain(Model model,String termsType){

       MemberTermsEntity terms = memberService.selectTerms().toEntity();
       model.addAttribute("termsType", termsType);
       model.addAttribute("terms", terms);
       model.addAttribute("termsType", termsType);



        return "/policy/terms";
    }

}
