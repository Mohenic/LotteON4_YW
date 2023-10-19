package kr.co.lotteon.controller.cs;

import kr.co.lotteon.service.CsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CsDeleteController {

    @Autowired
    private CsService csService;

    @GetMapping("/cs/delete")
    public String deleteQna(@RequestParam("no") int no, @RequestParam("cate1") String cate1, @RequestParam("cate2") String cate2){
        csService.deleteArticle(no);
        return "redirect:/cs/list?cate1="+cate1+"&cate2="+cate2;
    }

}
