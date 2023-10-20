package kr.co.lotteon.controller;

import kr.co.lotteon.dto.product.ProductCate1DTO;
import kr.co.lotteon.dto.product.ProductCate2DTO;
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

    

       
    @GetMapping("/product/mainProdCate1")
    public List<ProductCate2DTO> mainProdCate1(){
        log.info("mainProdCate1==========");
        List<ProductCate2DTO> cate2DTO = prodService.getAllProdCates();    
        // System.out.println("asdkfjalkdsj : " + cate1DTO);
        log.info("cateDTO:" + cate2DTO.size());
        
        return cate2DTO;
    }

    @GetMapping("/product/mainProdCate2")
    public int mainProdCate2(){
        log.info("mainProdCate2==========");
        
        return 100;
    }
}
