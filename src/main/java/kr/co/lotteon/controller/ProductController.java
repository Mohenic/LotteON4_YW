package kr.co.lotteon.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.cs.PageResponse2DTO;
import kr.co.lotteon.dto.product.PageRequestDTO;
import kr.co.lotteon.dto.product.PageResponseDTO;
import kr.co.lotteon.dto.product.ProductDTO;
import kr.co.lotteon.entity.product.ProductEntity;
import kr.co.lotteon.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        log.info("products: " + products.toString());
        model.addAttribute("products",products);
        model.addAttribute("prodNo",prodNo);

        model.addAttribute("price",price);
        

        return "/product/view";
    }

    @GetMapping("/product/order")
    public String order(){
        
        return "/product/order";
    }

    @PostMapping("/product/order")
    public String selectOrder(Model model, int totalQuantity, ProductDTO prodDTO, Authentication authentication  ) {
//        List<ProductDTO> dto
        
        
        model.addAttribute("totalQuantity",totalQuantity);
        model.addAttribute("prodDTO",prodDTO);
        
        
        log.info("11111111111111111111111111111111111111111111111" );
        log.info("222222222222222222222222222222222222222222222  " + totalQuantity );
        log.info("33333333333333333333333333333333333333333333  " + prodDTO.toString());
        
        log.info("============================"+ authentication.toString());
        log.info("============================"+ authentication.getPrincipal().toString());
        
//        log.info("dto: " + dto.toString());
        
        
        //log.info("prodDTO  1 =============================: " + request.toString());
        //int prodNo = request.getParameter("prodNo");
        /*log.info("prodDTO  1 =============================: " + prodNo);
        log.info("prodDTO  2 =============================: " + inputNum);
        log.info("prodDTO  3 =============================: " + price);
        log.info("prodDTO  4 =============================: " + finalValue);*/

        //ProductDTO orderProdDTO = prodService.selectOrderProd(request.getParameter("prodNo"));



        //model.addAttribute("ProdDTO",orderProdDTO);


     /*   log.info("orderProdDTO.getTotalPrice=============================: " + finalValue);
        log.info("orderProdDTO.getInputNum=============================: " + inputNum);
        log.info("orderProdDTO.getProdNum=============================: " + prodNo);
        log.info("orderProdDTO.price=============================: " + price);*/

        
        
        
        
        
        return "/product/order";
    }


    @GetMapping("/product/cart")
    public String cart() {

        return "/product/cart";
    }

    @PostMapping("/product/cart")
    public List<ProductDTO> getOrderProduct(){

        return  null;
    }

    @GetMapping("/product/cart/order")
    public String cartOrder() {

        return "/product/cartOrder";
    }

    @PostMapping("/product/cart/order")
    public List<ProductDTO> getCartOrderProduct(){

        return  null;
    }





    @GetMapping("/product/search")
    public String search(){

        return "/product/search";
    }

    @GetMapping("/product/complete")
    public String complete() {

        return "/product/complete";
    }

 



}