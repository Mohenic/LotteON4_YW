package kr.co.lotteon.controller.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {

    @GetMapping(value = {"/company", "/company/index"})
    public String index(){
        return "/company/index";
    }

    @GetMapping("/company/introduce")
    public String introduce(){
        return "/company/introduce";
    }

    @GetMapping("/company/notice")
    public String notice(){
        return "/company/notice";
    }

    @GetMapping("/company/promote")
    public String promote(){
        return "/company/promote";
    }

    @GetMapping("/company/manage")
    public String manage(){
        return "/company/manage";
    }
}
