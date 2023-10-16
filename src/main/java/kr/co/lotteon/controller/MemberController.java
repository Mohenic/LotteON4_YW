package kr.co.lotteon.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.dto.MemberTermsDTO;
import kr.co.lotteon.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/login")
    public String login(Model model, String success){
        model.addAttribute("success", success);
        return "/member/login";
    }

    @GetMapping("/member/join")
    public String join(){
        return "/member/join";
    }

    @GetMapping("/member/register")
    public String register(Model model, String type){
        model.addAttribute("type", type);
        return "/member/register";
    }
    @PostMapping ("/member/register")
    public String register(HttpServletRequest request, MemberDTO dto){
        dto.setRegip(request.getRemoteAddr());
        memberService.save(dto);
        return "redirect:/member/login?success=200";
    }
    @GetMapping("/member/registerSeller")
    public String registerSeller(Model model, String type){
        model.addAttribute("type", type);
        return "/member/registerSeller";
    }
    @PostMapping ("/member/registerSeller")
    public String registerSeller(HttpServletRequest request, MemberDTO dto){
        dto.setRegip(request.getRemoteAddr());
        memberService.save(dto);
        return "redirect:/member/login?success=200";
    }
    @GetMapping("/member/signup")
    public String signup(Model model, String type){
        MemberTermsDTO terms= memberService.selectTerms();
        model.addAttribute("terms", terms);
        log.info("terms : "+terms);
        model.addAttribute("type", type);
        log.info("type : "+type);
        return "/member/signup";
    }

}
