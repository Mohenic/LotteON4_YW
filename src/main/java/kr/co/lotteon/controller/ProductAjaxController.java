package kr.co.lotteon.controller;

import kr.co.lotteon.dto.product.ProductCate1DTO;
import kr.co.lotteon.entity.product.ProductCate1Entity;
import kr.co.lotteon.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j2
@RestController
@RequiredArgsConstructor
public class ProductAjaxController {
    
    //@RequiredArgsConstructor 를 선언하면 final로 처리된 것들을 주입해주기 때문에 autowired가필요 없다.
    private final ProductService prodService;

    
/*    @GetMapping("/productIndexCate")
    public ProductCate2DTO productIndex(@RequestBody ProductCate2DTO cate2DTO){
        
        //return prodService.findProductIndexCate(cate2DTO);
        return null;
    }*/

  /*  public ProductCate1DTO findByProductIndexCate1() {

        return prodService.findByProductIndexCate1();
    }*/
    
        @ResponseBody
        @GetMapping("/mainProdCate1")
        public List<ProductCate1Entity> mainProdCate1(){
            
        List<ProductCate1Entity> cate1DTO = prodService.getAllProdCate1();


        log.info("cate1DTO:" + cate1DTO.toString());
        
            return cate1DTO;
        };
}
