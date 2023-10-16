package kr.co.lotteon.controller;

import kr.co.lotteon.dto.product.PageRequestDTO;
import kr.co.lotteon.dto.product.PageResponseDTO;
import kr.co.lotteon.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    
    @GetMapping("/product/list")
    public String list(Model model, PageRequestDTO pagerequest){

        //PageResponseDTO pageResponseDTO = ProductService.findByProdunctAndCate(PageRequestDTO pagerequest);

    
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
