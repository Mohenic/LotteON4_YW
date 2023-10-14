package kr.co.lotteon.controller.cs;

import kr.co.lotteon.dto.cs.PageRequestDTO;
import kr.co.lotteon.dto.cs.PageResponseDTO;
import kr.co.lotteon.service.CsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CsListController {

    @Autowired
    private CsService csService;

    //{cate1}/{cate2}
    //@PathVariable("cate1") String cate1,@PathVariable("cate2") String cate2 ,
    @GetMapping("/cs/list")
    public String list(Model model, PageRequestDTO pageRequestDTO) {


        PageResponseDTO articles = null;
        if (pageRequestDTO.getCate2().equals("all")) {
            articles = csService.selectCate1(pageRequestDTO);
        } else {
            articles = csService.selectCate1AndCate2(pageRequestDTO);
        }

        model.addAttribute("articles",articles);

        return "/cs/list";
    }
}
