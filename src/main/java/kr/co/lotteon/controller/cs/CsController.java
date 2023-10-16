package kr.co.lotteon.controller.cs;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CsController {

    @GetMapping("/cs/index")
    public String index(){
        return "/cs/index";
    }



}
