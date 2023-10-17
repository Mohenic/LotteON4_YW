package kr.co.lotteon.controller;

import kr.co.lotteon.dto.cs.PageResponse2DTO;
import kr.co.lotteon.dto.product.PageRequestDTO;
import kr.co.lotteon.dto.product.PageResponseDTO;
import kr.co.lotteon.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class ProductController {
    
    private ProductService prodService;
    
    
    @GetMapping("/product/list")
    public String list(Model model, PageRequestDTO pagerequest){

        PageResponseDTO articles1 = null;
        PageResponse2DTO articles2 = null;
        log.info("cate1:" + pagerequest.getCate1()); //10들고왔음
        
         articles1 = prodService.findByCate1Product(pagerequest);
         
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
