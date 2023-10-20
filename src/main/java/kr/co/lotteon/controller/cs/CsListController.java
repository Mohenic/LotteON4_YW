package kr.co.lotteon.controller.cs;

import kr.co.lotteon.dto.cs.PageRequestDTO;
import kr.co.lotteon.dto.cs.PageResponse2DTO;
import kr.co.lotteon.dto.cs.PageResponseDTO;
import kr.co.lotteon.entity.cs.CsArticleFaqEntity;
import kr.co.lotteon.entity.cs.CsArticleQnaEntity;
import kr.co.lotteon.entity.cs.CsCate2Entity;
import kr.co.lotteon.entity.cs.CsCate3Entity;
import kr.co.lotteon.service.CsService;
import kr.co.lotteon.util.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Log4j2
public class CsListController {

    @Autowired
    private CsService csService;


    private Utils utils;

    //{cate1}/{cate2}
    //@PathVariable("cate1") String cate1,@PathVariable("cate2") String cate2 ,
    @GetMapping("/cs/list")
    public String list(Model model, PageRequestDTO pageRequestDTO) {


        PageResponseDTO articles1 = null;
        PageResponse2DTO articles2 = null;

        List<CsCate3Entity> entity2 = csService.selectCate3List();
        
        log.info("cate1:" + pageRequestDTO.getCate1());
        if(pageRequestDTO.getCate1().equals("notice")) {
            if (pageRequestDTO.getCate2().equals("all")) {
                articles1 = csService.selectCate1(pageRequestDTO);
                model.addAttribute("articles",articles1);
                List<CsCate2Entity> cate2Detail = csService.selectCate2Detail();

            } else {
                articles1 = csService.selectCate1AndCate2(pageRequestDTO);
                model.addAttribute("articles",articles1);
            }
        }else if (pageRequestDTO.getCate1().equals("qna")){
                articles2 = csService.selectQnaCate1AndCate2(pageRequestDTO);
                List<CsArticleQnaEntity> qnaEntityList = csService.selectArticleAndCate();
                log.info(qnaEntityList);

                model.addAttribute("articles",articles2);
                model.addAttribute("qnalist",qnaEntityList);

        }


        String cate1= pageRequestDTO.getCate1();
        String cate2= pageRequestDTO.getCate2();

        CsCate2Entity entity = csService.selectCate2Detail(cate2);
        
        // 여기에서 cate2 뿌려줄것

        model.addAttribute("cate1",cate1);
        model.addAttribute("cate2",cate2);
        model.addAttribute("entity",entity);
        model.addAttribute("entity2",entity2);



        return "/cs/list";
    }

    @GetMapping("/cs/faq/list")
    public String faqList(@RequestParam("cate1") String cate1 ,@RequestParam("cate2") String cate2 , Model model){

        log.info(cate1);
        log.info(cate2);
        List<CsCate3Entity> types = csService.selectCate2(cate2);
        log.info("type : "+types);
        List<CsArticleFaqEntity> articles = csService.selectFaqArticles(cate1,cate2);
        log.info("articles"+articles);


        model.addAttribute("articles",articles);
        model.addAttribute("cate1",cate1);
        model.addAttribute("cate2",cate2);

        log.info(cate1);
        log.info(cate2);
        model.addAttribute("types",types);

        return "/cs/faq/list";



    }
}
