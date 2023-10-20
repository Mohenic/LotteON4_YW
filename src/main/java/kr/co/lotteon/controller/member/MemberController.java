package kr.co.lotteon.controller.member;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.dto.MemberTermsDTO;
import kr.co.lotteon.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private BuildProperties buildProperties; // 빌드 정보를 갖는 객체 주입

    @ModelAttribute("appInfo")
    public String appversion(){
        String appName = buildProperties.getName(); // settings.gradle 파일에서 앱이름 가져옴
        String version = buildProperties.getVersion(); // build.gradle 파일에서 버전값 가져옴
        return appName+version;
    }

    @GetMapping("/member/login")
    public String login(Model model, String success){
        log.info("success : "+success);
        if(success != null){
            model.addAttribute("success", success);
            return "/member/login";
        }else{
            return "/member/login";
        }


    }

    @GetMapping("/member/join")
    public String join(Model model){
        return "/member/join";
    }

    @GetMapping("/member/register")
    public String register(Model model, String type){
        model.addAttribute("type", type);
        return "/member/register";
    }
    @PostMapping ("/member/register")
    public String register(Model model, HttpServletRequest request, MemberDTO dto){
        dto.setRegip(request.getRemoteAddr());
        log.info("email : "+dto.getEmail());
        memberService.save(dto);
        return "redirect:/member/login?success=200";
    }
    @GetMapping("/member/registerSeller")
    public String registerSeller(Model model, String type){
        model.addAttribute("type", type);
        return "/member/registerSeller";
    }
    @PostMapping ("/member/registerSeller")
    public String registerSeller(Model model, HttpServletRequest request, MemberDTO dto){
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
