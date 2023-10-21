package kr.co.lotteon.controller.cs;


import kr.co.lotteon.dto.cs.PageRequestDTO;
import kr.co.lotteon.dto.cs.PageResponse2DTO;
import kr.co.lotteon.dto.cs.PageResponseDTO;
import kr.co.lotteon.entity.cs.CsArticleQnaEntity;
import kr.co.lotteon.entity.cs.CsCate2Entity;
import kr.co.lotteon.entity.cs.CsCate3Entity;
import kr.co.lotteon.service.CsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Log4j2
public class CsSearchController {

    @Autowired
    private CsService csService;

    @GetMapping("/cs/search")
    public String search(String search, String select ,PageRequestDTO pageRequestDTO , Model model) {

        PageResponseDTO articles1 = null;
        PageResponse2DTO articles2 = null;
        log.info("search:" + select);
        if(select.isBlank()) {
            pageRequestDTO.setCate2(select);
        }
        List<CsCate3Entity> entity2 = csService.selectCate3List();

        log.info("cate1:" + pageRequestDTO.getCate1());
        if(pageRequestDTO.getCate1().equals("notice")) {
            if (pageRequestDTO.getCate2().equals("all")) {
                articles1 = csService.selectNoticeAllSearch(pageRequestDTO,search);
                model.addAttribute("articles",articles1);

            } else {
                articles1 = csService.selectNoticeSearch(pageRequestDTO,search);
                model.addAttribute("articles",articles1);
            }
        }else if (pageRequestDTO.getCate1().equals("qna")){
            articles2 = csService.selectQnaSearch(pageRequestDTO,search);
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
        model.addAttribute("search",search);



        return "/cs/search";
    }

    @PostMapping("/cs/search")
    public String search2(String cate1, String cate2, String search, PageRequestDTO pageRequestDTO , Model model) {



        return "redirect:/cs/search";
    }

}
