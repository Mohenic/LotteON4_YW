package kr.co.lotteon.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.dto.MemberPointDTO;
import kr.co.lotteon.dto.cs.PageResponse2DTO;
import kr.co.lotteon.dto.product.*;
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

    @PostMapping("/product/complete")
    public String complete(String uid, int ordTotPrice, int ordDelivery, int ordCount, int prodNo, int usedPoint, int ordDiscount, int ordPrice,
                           int savePoint, int getPoint, ProductDTO product, String memberHp,
                           ProductOrderItemDTO orderItem, ProductOrderDTO prodOrder, MemberPointDTO mPointDto, MemberDTO memberDto, Model model) {

        // ProductOrderDTO
        prodOrder.setOrdUid(uid);  // ProductOrderDTO 필드에 매핑
        prodOrder.setOrdStatus(1);  
        prodOrder.setOrdPayment(1); 
        prodOrder.setDelivery(1); 
        // prodOrder.setProdName(prodName);
        
        // MemberPointDTO
        mPointDto.setUid(uid);
        
        // ProductOrderItemDTO
        orderItem.setTotal(ordTotPrice);
        orderItem.setDelivery(ordDelivery);
        orderItem.setCount(ordCount);
        orderItem.setProdNo(prodNo);
        orderItem.setPrice(ordPrice);
        orderItem.setDiscount(ordDiscount);
        orderItem.setPoint(usedPoint);
        
        // MemberDTO
        // member
        
        
        log.info("Product getOrdUid =================================" + prodOrder.getOrdUid());
        log.info("Product getUid =================================" + mPointDto.getUid());
        log.info("Product mPointDto.toString =================================" + mPointDto.toString());
        log.info("Product prodOrder.toString =================================" + prodOrder.toString());
        
        // order
        int inOrderDto = prodService.insertOrder(prodOrder);
        log.info("Product inOrderDto +++++++++++++++++++++ "  + inOrderDto);
        log.info(inOrderDto);
        
        // select Order
        ProductOrderDTO selectOrderDTO = prodService.selectOrder();
        int ordNo = selectOrderDTO.getOrdNo();
        
        log.info("투스트링=== " + selectOrderDTO.toString());
        log.info("getOrdNo=== " + selectOrderDTO.getOrdNo());
        log.info("ordNo값=== " + ordNo);
        
        
        // order Item
        prodService.insertOrderItem(orderItem, ordNo);
        
        
        // insert Point
        if(savePoint > 0) {
            mPointDto.setPoint(savePoint);
            mPointDto.setDescript("적립");
            prodService.insertMPoint(mPointDto, ordNo);
        }
        
        if(usedPoint > 0){
            mPointDto.setPoint(usedPoint);
            mPointDto.setDescript("사용");
            prodService.insertMPoint(mPointDto, ordNo);
        }
        
        // member Point
        int memberPoint = getPoint + savePoint - usedPoint; 
        log.info("memberP=)))))))))))))" + getPoint);
        log.info("memberP=((((((((((((( " + savePoint);
        log.info("memberP=&&&&&&&&&&" + usedPoint);
        log.info("member**************************************"  + memberPoint);
        log.info("member**************************************212라인 "  + memberDto.getUid());
        log.info("member**************************************214라인 "  + memberDto.getPoint());
        prodService.updatePoint(memberDto, memberPoint);
        
        model.addAttribute("productItem" , orderItem);
        model.addAttribute("prodOrder" , prodOrder);
        model.addAttribute("mPointDto" , mPointDto);
        model.addAttribute("prodDTO" , product);
        model.addAttribute("member" , memberDto);
        model.addAttribute("ordNo" , ordNo);
        model.addAttribute("memberHp" , memberHp);
        
        return "/product/complete";
    }

    @PostMapping("/product/cart/complete")
    public String cartComplete() {

        return "/product/complete";
    }


}