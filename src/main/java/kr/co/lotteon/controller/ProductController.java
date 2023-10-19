package kr.co.lotteon.controller;

import kr.co.lotteon.dto.cs.PageResponse2DTO;
import kr.co.lotteon.dto.product.PageRequestDTO;
import kr.co.lotteon.dto.product.PageResponseDTO;
import kr.co.lotteon.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class ProductController {
    @Autowired
    private ProductService prodService;
    
    
    @GetMapping("/product/list")
    public String list(Model model, PageRequestDTO pagerequest){

        PageResponseDTO articles1 = null;
        PageResponse2DTO articles2 = null;
        log.info("prodCate1:" + pagerequest.getProdCate1()); //10들고왔음
        
         articles1 = prodService.findByCate1Product(pagerequest);
         
         log.info("articles1 Change pg Num: " + articles1.getPg()); //
         log.info("articles1 Change pg Num: " + articles1.getEnd()); //
         log.info("articles1 Change pg Num: " + articles1.getStart()); //
         log.info("articles1 Change pg Num: " + articles1.toString()); //
         
         model.addAttribute("articles",articles1);
    
        return "/product/list";
    }
    
    @GetMapping("/product/view")
    public String view(){
        
        return "/product/view";
    }
    
    @GetMapping("/product/order")
    public String order(){
        
        return "/product/order";
    }
    
    @GetMapping("/product/search")
    public String search(){
    
        return "/product/search";
    }

    @GetMapping("/product/complete")
    public String complete() {
        
        return "/product/complete";
     }
     
    @GetMapping("/product/cart")
    public String cart() {
    
        return "/product/cart";
    }
    
    
    
    
}
