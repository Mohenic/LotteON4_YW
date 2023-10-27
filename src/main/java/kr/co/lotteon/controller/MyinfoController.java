package kr.co.lotteon.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.service.MyinfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
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

    @PostMapping("/my/info/modify")
    public String myinfoModify(MemberDTO dto){
        dto.setEmail(dto.getEmail1() + "@" + dto.getEmail2());
        dto.setHp(dto.getHp1() + "-" + dto.getHp2() + "-" + dto.getHp3());

        log.info("dto : " + dto);

        iService.myinfoModify(dto);
        return "redirect:/my/home?uid="+dto.getUid();
    }

    @GetMapping("/my/passModify")
    public String passModify(Model model, String uid){
        log.info("uid: " + uid);
        String pass = iService.passCheck(uid);
        model.addAttribute("pass",pass);

        log.info("pass : " + pass);

        return "/my/passModify";
    }


}
