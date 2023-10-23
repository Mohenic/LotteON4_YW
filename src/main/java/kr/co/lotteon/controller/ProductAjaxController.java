package kr.co.lotteon.controller;

import kr.co.lotteon.dto.product.ProductCate1DTO;
import kr.co.lotteon.dto.product.ProductCate2DTO;
import kr.co.lotteon.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;


@Log4j2
@RestController
@RequiredArgsConstructor
public class ProductAjaxController {
    
    //@RequiredArgsConstructor 를 선언하면 final로 처리된 것들을 주입해주기 때문에 autowired가필요 없다.
    private final ProductService prodService;

    

    @GetMapping("/product/mainProdCate2")
    public String mainProdCate2(){
        List<ProductCate1DTO> productCate1DTOS = prodService.getProdCate();

        StringBuilder html = new StringBuilder("<li><i class=\"fa fa-bars\" aria-hidden=\"true\"></i>카테고리</li>");

        for (ProductCate1DTO cate1 : productCate1DTOS) {
            html.append("<li>")
                    .append("<a href=\"")
                    .append(ServletUriComponentsBuilder.fromCurrentContextPath()
                            .path("/product/list")
                            .queryParam("pg", 1)
                            .queryParam("prodCate1", cate1.getCate1())
                            .queryParam("prodCate2", 0)
                            .toUriString())
                    .append("\">")
                    .append("<i class=\"fas\"></i>")
                    .append(cate1.getC1Name())
                    .append("</a>")
                    .append("<ol>");

            for (ProductCate2DTO cate2 : cate1.getCate2s()) {
                html.append("<li>")
                        .append("<a href=\"")
                        .append(ServletUriComponentsBuilder.fromCurrentContextPath()
                                .path("/product/list")
                                .queryParam("pg", 1)
                                .queryParam("prodCate1", cate1.getCate1())
                                .queryParam("prodCate2", cate2.getCate2())
                                .toUriString())
                        .append("\">")
                        .append(cate2.getC2Name())
                        .append("</a></li>");
            }

            html.append("</ol></li>");
        }

        return html.toString();
    }
}

