package kr.co.lotteon.controller;


import kr.co.lotteon.dto.product.ProductCate1DTO;
import kr.co.lotteon.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
public class MainController {

    private ProductAjaxController service;
    
   
    @GetMapping(value = {"/","/index"})  //findByProductIndexCate1
    public String main(Model model){

/*        ProductCate1DTO cate1DTO = service.findByProductIndexCate1();
        
        model.addAttribute("cate1DTO", cate1DTO);
        
        log.info("cate1DTO:" + cate1DTO.toString());*/
        
        
        return "/index";
    }


}
