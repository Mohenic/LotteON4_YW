package kr.co.lotteon.controller.cs;

import kr.co.lotteon.entity.cs.CsArticleFaqEntity;
import kr.co.lotteon.entity.cs.CsArticleNoticeEntity;
import kr.co.lotteon.entity.cs.CsArticleQnaEntity;
import kr.co.lotteon.service.CsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class CsViewController {

    @Autowired
    private CsService service;

    @GetMapping("/cs/view")
    public String csView(@RequestParam("cate1") String cate1, @RequestParam("cate2") String cate2
            , @RequestParam("no") int no, Model model){

        log.info("cate1: "+cate1);
        log.info("cate2: "+cate2);
        log.info("no: "+no);

        if(cate1.equals("notice")){
            CsArticleNoticeEntity article1 =service.selectCsArticleNotice(no);
            model.addAttribute("articles",article1);
            log.info("no: "+article1);
        }else if(cate1.equals("faq")){
            CsArticleFaqEntity article2 =service.selectCsArticleFaq(no);
            model.addAttribute("articles",article2);
            log.info("no: "+article2);
        }else if(cate1.equals("qna")){
            CsArticleQnaEntity articles3 =service.selectCsArticleQna(no);
            CsArticleQnaEntity comment =service.selectCsArticleQnaComment(no);
            model.addAttribute("articles",articles3);
            model.addAttribute("comment",comment);
            log.info("no: "+articles3);
        }


        model.addAttribute("cate1",cate1);
        model.addAttribute("cate2",cate2);

        return "/cs/view";


    }



}
