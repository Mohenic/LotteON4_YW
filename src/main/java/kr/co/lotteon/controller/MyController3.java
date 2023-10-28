package kr.co.lotteon.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.dto.cs.CsArticleQnaDTO;
import kr.co.lotteon.dto.my.MyInfoDTO;
import kr.co.lotteon.dto.product.ProductDTO;
import kr.co.lotteon.dto.product.ProductOrderDTO;
import kr.co.lotteon.dto.product.ProductOrderItemDTO;
import kr.co.lotteon.entity.MemberEntity;
import kr.co.lotteon.entity.product.ProductEntity;
import kr.co.lotteon.security.MyUserDetails;
import kr.co.lotteon.service.CsService;
import kr.co.lotteon.service.MyService;
import kr.co.lotteon.service.MyService2;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.valves.RemoteAddrValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@Log4j2
public class MyController3 {

    @Autowired
    private MyService2 myService2;

    @Autowired
    private CsService csService;



    @GetMapping("/my/checkRecive")
    @ResponseBody
    public int checkRecive(@RequestParam("no") int no, @AuthenticationPrincipal Object principal) { //AuthenticationPrincipal 현재 로그인 사용자 정보 가져오는 어노테이션(이하 @)

        MemberEntity member = ((MyUserDetails) principal).getMember(); //@통해 현재 로그인 사용자 정보 가지고옴 다만 데이터 타입때문에 업캐스팅 해둠
        log.info(member);
        String uid = member.getUid();

       ProductOrderDTO productorder = myService2.selectOrderStatus(uid,no);

       int result = productorder.getOrdStatus();
        return result;
    }

    @GetMapping("/my/checkReview")
    @ResponseBody
    public int checkReview(@RequestParam("prodNo") int prodNo,@RequestParam("ordno") int ordno, @AuthenticationPrincipal Object principal) {

        MemberEntity member = ((MyUserDetails) principal).getMember(); //@통해 현재 로그인 사용자 정보 가지고옴 다만 데이터 타입때문에 업캐스팅 해둠
        log.info(member);
        String uid = member.getUid();

        return myService2.selectReviewstatus(ordno,prodNo,uid);
    }

    @GetMapping("/my/checkProduct")
    @ResponseBody
    public ProductDTO checkProduct(@RequestParam("prodNo") int prodno){


        return myService2.selectProduct(prodno);
    }

    @PostMapping("/my/reviewRegister")
    @ResponseBody
    public void reviewRegister(@RequestParam("prodNo") int prodNo,
                                 @RequestParam("content") String content,
                                 @RequestParam("rating") int rating,
                                @RequestParam("price") int price,
                                @RequestParam("no") int no,
                                @AuthenticationPrincipal Object principal,
                              HttpServletRequest req
    ) {

        String uid = ((MyUserDetails) principal).getMember().getUid();
        String rdate = LocalDateTime.now().toString();
        String regip = req.getRemoteAddr();
        int point= price/10;
        log.info(point);
        String descript="적립";
        myService2.writeReview(prodNo,content,rating,uid,regip,rdate);
        myService2.insertPoint(no,uid,point,rdate,descript);

    }

    @PostMapping("/my/updateOrdstatus")
    @ResponseBody
    public void updateOrdstatus(@RequestParam("no") int no,@AuthenticationPrincipal Object principal){

        String uid = ((MyUserDetails) principal).getMember().getUid();
        myService2.updateOrderStatus(no,uid);


    }

    @PostMapping("/my/seller")
    @ResponseBody
    public MemberDTO mySeller(@RequestParam("seller") String seller){

        MemberDTO dto =myService2.selectSeller(seller);
        log.info(dto);

        return dto;
    }

    @PostMapping("/my/writeQna")
    @ResponseBody
    public String writeQna(@RequestParam("ordUid") String ordUid){

        MemberEntity entity=myService2.selectMyMember(ordUid);
        String email=entity.getEmail();
        return email;
    }

    @PostMapping("/my/insertQna")
    public String insertQna (
            @RequestParam("uid") String uid,
            @RequestParam("content") String content,
            @RequestParam("email") String email,
            @RequestParam("title") String title,
            @RequestParam("kind") String kind,
            HttpServletRequest req){

        String regip = req.getRemoteAddr();
        LocalDateTime rdate = LocalDateTime.now();
        String cate1 = "qna";
        String type = kind;
        String writer = uid;
        String cate2=null;

        if(kind.equals("oproduct")){
            cate2="order";
        }else if(kind.equals("dinfo")){
            cate2="delivery";
        }else if(kind.equals("return")){
            cate2="cancle";
        }else if(kind.equals("minfo")){
            cate2="member";
        }else if(kind.equals("change")){
            cate2="cancle";
        }
        //더 간소화활수있지만 귀찮다
        CsArticleQnaDTO dto = new CsArticleQnaDTO();
        dto.setCate1(cate1);
        dto.setCate2(cate2);
        dto.setType(type);
        dto.setTitle(title);
        dto.setContent(content);
        dto.setWriter(writer);
        dto.setRegip(regip);
        dto.setRdate(rdate);
        dto.setUseyn("Y");

        csService.insertQna(dto);

        return "redirect:/my/home?uid="+uid;

    }

    @PostMapping("/my/orderSelect")
    @ResponseBody
    public ProductOrderItemDTO orderSelect(@RequestParam("itemNo") int itemNo){
        ProductOrderItemDTO dto =myService2.selectOrderItem(itemNo);
        return dto;
    }
}
