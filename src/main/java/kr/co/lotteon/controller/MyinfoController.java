package kr.co.lotteon.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.service.MyinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyinfoController {

    @Autowired
    private MyinfoService iService;

    @GetMapping("/my/info")
    public String info(HttpServletRequest req, Model model){

        String uid = req.getParameter("uid");
        MemberDTO list = iService.myinfoList(uid);
        model.addAttribute("list",list);

        return "/my/info";
    }

}
