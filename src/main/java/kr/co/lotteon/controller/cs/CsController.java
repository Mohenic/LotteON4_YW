package kr.co.lotteon.controller.cs;


import kr.co.lotteon.entity.cs.CsArticleNoticeEntity;
import kr.co.lotteon.entity.cs.CsArticleQnaEntity;
import kr.co.lotteon.service.CsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class CsController {

    @Autowired
    private CsService service;

    @GetMapping("/cs/index")
    public String index(Model model){

        List<CsArticleNoticeEntity> notice = service.selectNoticeTop5Desc();
        List<CsArticleQnaEntity> qna = service.selectQnaTop5Desc();

        model.addAttribute("notices",notice);
        model.addAttribute("qnas",qna);


        return "/cs/index";
    }



}
