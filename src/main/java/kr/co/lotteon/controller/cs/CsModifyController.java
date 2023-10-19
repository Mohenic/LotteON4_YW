package kr.co.lotteon.controller.cs;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.cs.CsArticleQnaDTO;
import kr.co.lotteon.entity.cs.CsArticleQnaEntity;
import kr.co.lotteon.entity.cs.CsCate3Entity;
import kr.co.lotteon.service.CsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Log4j2
public class CsModifyController {

    @Autowired
    private CsService service;

    @GetMapping("/cs/qna/modify")
    public String write(@RequestParam("cate1") String cate1, @RequestParam("cate2") String cate2, @RequestParam("no")int no, Model model){

        List<CsCate3Entity> csCate2=null;
        CsArticleQnaEntity entity=null;
    if(cate2.equals("all")) {
        csCate2= service.selectCate();
        entity=service.selectArticleNo(no);
    }else {
        csCate2 = service.selectCate2(cate2);
        entity=service.selectArticleNo(no);
    }



        model.addAttribute("csCate2",csCate2);
        model.addAttribute("entity",entity);
        model.addAttribute("cate1",cate1);
        model.addAttribute("cate2",cate2);




        return "/cs/qna/modify";
    }

    @PostMapping("/cs/qna/modify")
    public String insert(HttpServletRequest request, CsArticleQnaDTO dto){

        dto.setRegip(request.getRemoteAddr());
        dto.setUseyn("Y");
        log.info("dto");

        service.updateQna(dto);

        return  "redirect:/cs/list?cate1="+dto.getCate1()+"&cate2="+dto.getCate2();
    }

    @GetMapping("/cs/qna/modify/selectcate2")
    @ResponseBody
    public List<CsCate3Entity> selectcate2(@RequestParam("cate2") String cate2){
        log.info("cate2 : "+cate2);

        List<CsCate3Entity> selectvalue=service.selectCate2(cate2);

        return selectvalue;

    }


}
