package kr.co.lotteon.controller;


import kr.co.lotteon.dto.product.ProductCate1DTO;
import kr.co.lotteon.entity.product.ProductEntity;
import kr.co.lotteon.service.MainService;
import kr.co.lotteon.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Log4j2
@Controller
public class MainController {

    @Autowired
    private MainService mainService;
    private ProductAjaxController service;

    @Autowired
    private BuildProperties buildProperties; // 빌드 정보를 갖는 객체 주입

    @GetMapping(value = {"/","/index"})  //findByProductIndexCate1
    public String main(Model model){

        String appName = buildProperties.getName(); // settings.gradle 파일에서 앱이름 가져옴
        String version = buildProperties.getVersion(); // build.gradle 파일에서 버전값 가져옴
        System.out.println("appName : " + appName);
        System.out.println("version : " + version);

        model.addAttribute("appInfo", appName+version);

        List<ProductEntity> productHit =mainService.selectProductHtiList();
        List<ProductEntity> productScore =mainService.selectProductScoreList();
        List<ProductEntity> productNew =mainService.selectProductNewList();
        List<ProductEntity> productDiscount =mainService.selectProductDiscountList();
        List<ProductEntity> productSold =mainService.selectProductSoldList();

        model.addAttribute("productHit", productHit);
        model.addAttribute("productScore", productScore);
        model.addAttribute("productNew", productNew);
        model.addAttribute("productDiscount", productDiscount);
        model.addAttribute("productSold", productSold);
        return "/index";
    }


}
