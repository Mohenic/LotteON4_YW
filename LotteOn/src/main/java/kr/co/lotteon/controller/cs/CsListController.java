package kr.co.lotteon.controller.cs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CsListController {

    @GetMapping("/cs/list/{cate1}")
    public String list(@PathVariable("cate1") String cate1){

        return "/cs/"+cate1+"/list";
    }
}
