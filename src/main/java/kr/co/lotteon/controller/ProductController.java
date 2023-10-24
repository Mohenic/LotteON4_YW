package kr.co.lotteon.controller;

import kr.co.lotteon.dto.cs.PageResponse2DTO;
import kr.co.lotteon.dto.product.PageRequestDTO;
import kr.co.lotteon.dto.product.PageResponseDTO;
import kr.co.lotteon.dto.product.ProductDTO;
import kr.co.lotteon.entity.product.ProductEntity;
import kr.co.lotteon.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log4j2
@Controller
public class ProductController {
    @Autowired
    private ProductService prodService;
    
    
    @GetMapping("/product/list")
    public String list(Model model, PageRequestDTO pagerequest) {

        PageResponseDTO articles1 = null;
        PageResponseDTO articles2 = null;
        
        log.info("prodCate1:" + pagerequest.getProdCate1()); //10들고왔음
        log.info("sort : " + pagerequest.getSort());
        log.info("orderBy : " + pagerequest.getOrderBy());

        log.info("prodCate1: ===========================" + pagerequest.getSize()); //10
        
        log.info("prodCate1: ===========================" + pagerequest.toString()); //10
        log.info("prodCate1: ===========================" + pagerequest.getProdCate1()); //10
        log.info("prodCate1: ===========================" + pagerequest.getProdCate2()); //10


        if (pagerequest.getProdCate2() != 0) {
            // 만약 prodCate2가 존재한다면 articles2를 조회
            articles1 = prodService.findByCate2Product(pagerequest);
            model.addAttribute("articles", articles1);
        } else {
            // 그 외의 경우에는 articles1를 조회
            articles1 = prodService.findByCate1Product(pagerequest);
            model.addAttribute("articles", articles1);
        }




        log.info("articles1 Change pg Num: " + articles1.getPg()); //
         log.info("articles1 Change pg Num: " + articles1.getEnd()); //
         log.info("articles1 Change pg Num: " + articles1.getStart()); //
         log.info("articles1 Change pg Num: " + articles1.toString()); //
         
         model.addAttribute("articles",articles1);
    
        return "/product/list";
    }
    
    @GetMapping("/product/view")
    public String view(int prodNo, int price, Model model){

        
        List<ProductEntity> products = prodService.getAllProduct(prodNo);
        
        model.addAttribute("products",products);
        model.addAttribute("prodNo",prodNo);
        model.addAttribute("price",price);
        
        return "/product/view";
    }
    
    @GetMapping("/product/order")
    public String order(Model model, ProductDTO prodDTO){
        
        log.info("prodDTO=============================: " + prodDTO.getProdNo());
        log.info("prodDTO=============================: " + prodDTO.getFinalValue());
        
        ProductDTO orderProdDTO = prodService.selectOrderProd(prodDTO.getProdNo()); 
        
        
        model.addAttribute("ProdDTO",orderProdDTO);
        
        
        log.info("orderProdDTO.getTotalPrice=============================: " + prodDTO.getFinalValue());
        log.info("orderProdDTO.getInputNum=============================: " + prodDTO.getInputValue());
        log.info("orderProdDTO.getProdNum=============================: " + orderProdDTO.getProdNo());
        
/*        prodNO 서치 + 믈픔 갯수;
        
                        
        prodDTO.getProdNo();~~~
        model.addAttribute("prodNO",prodDTO.getProdNo());~~
                */
                
        
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
