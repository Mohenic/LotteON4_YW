package kr.co.lotteon.controller;

import kr.co.lotteon.dto.product.ProductCate1DTO;
import kr.co.lotteon.dto.product.ProductCate2DTO;
import kr.co.lotteon.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;


@Log4j2
@RestController
@RequiredArgsConstructor
public class ProductAjaxController {
    
 /*   // @RequiredArgsConstructor 를 선언하면 final로 처리된 것들을 주입해주기 때문에 autowired가필요 없다.
    private final ProductService prodService;

    
    @GetMapping("/productIndexCate")
    public ProductCate2DTO productIndex(@RequestBody ProductCate2DTO cate2DTO){
        
        //return prodService.findProductIndexCate(cate2DTO);
        return null;
    }

    public ProductCate1DTO findByProductIndexCate1() {

        return prodService.findByProductIndexCate1();
    }*/
}
