package kr.co.lotteon.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.cs.CsArticleQnaDTO;
import kr.co.lotteon.dto.my.MyInfoDTO;
import kr.co.lotteon.dto.product.ProductOrderItemDTO;
import kr.co.lotteon.dto.product.ProductReviewDTO;
import kr.co.lotteon.entity.MemberEntity;
import kr.co.lotteon.entity.cs.CsArticleQnaEntity;
import kr.co.lotteon.entity.cs.CsCate3Entity;
import kr.co.lotteon.entity.my.CouponEntity;
import kr.co.lotteon.service.CsService;
import kr.co.lotteon.service.MyService;
import kr.co.lotteon.service.MyService2;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@Log4j2
public class MyController2 {
    @Autowired
    private BuildProperties buildProperties; // 빌드 정보를 갖는 객체 주입

    @Autowired
    private MyService2 myService2; // �

    @Autowired
    public CsService csService;


    @Autowired
    private MyService myService; // �


    @ModelAttribute("appInfo")
    public String appversion(){
        String appName = buildProperties.getName(); // settings.gradle 파일에서 앱이름 가져옴
        String version = buildProperties.getVersion(); // build.gradle 파일에서 버전값 가져옴
        return appName+version;
    }

    @ModelAttribute("myInfo")
    public MyInfoDTO myinfo(String uid,
                            String ordUid,
                            String writer){

        log.info("uid : "+uid);
        log.info("ordUid : "+ordUid);
        log.info("writer : "+writer);
        MyInfoDTO member = null;
        if(uid != null){
            member = myService.findMyInfo(uid);
        }else if(ordUid != null){
            member = myService.findMyInfo(ordUid);
        }else if(writer != null){
            member = myService.findMyInfo(writer);
        }
        log.info("member : "+member);
        return member;
    }


    @GetMapping("/my/home")
    public String home(Model model,String uid){

       List<ProductReviewDTO> reviewLimit5= myService2.selectMyReviewLimit5(uid);
       List<CsArticleQnaDTO> qnaLimit5= myService2.selectQnaMyLimit5(uid);
        MemberEntity member=myService2.selectMyMember(uid);
        List<ProductOrderItemDTO> myItems = myService2.selectProductMyHomeLimit5(uid);

       model.addAttribute("reviewLimit5", reviewLimit5);
       model.addAttribute("qnaLimit5", qnaLimit5);
       model.addAttribute("member", member);
       model.addAttribute("myItems", myItems);

        return "/my/home";
    }
    @GetMapping("/my/coupon")
    public String coupon(Model model, String uid){

        List<CouponEntity> entityList1=myService2.selectCoupon(uid);

        LocalDateTime realdate = LocalDateTime.now();

        log.info(realdate);
        model.addAttribute("entityList1", entityList1);
        model.addAttribute("realdate", realdate);

        return "/my/coupon";
    }
    @GetMapping("/my/qna")
    public String qna(Model model , String writer, HttpServletRequest req){

        String pg = req.getParameter("pg");


        //페이지 관련 변수
        int currentPage = (pg != null) ? Integer.parseInt(pg) : 1;
        int total = myService2.selectCountQna();
        int start = (currentPage - 1) * 5;
        int lastPageNum = (int) Math.ceil(total / 10.0);
        int pageGroupCurrent = (int) Math.ceil(currentPage / 5.0);
        int pageGroupStart = (pageGroupCurrent - 1) * 5 + 1;
        int pageGroupEnd = Math.min(pageGroupCurrent * 5, lastPageNum);
        int pageStartNum = total - start;

        List<CsArticleQnaEntity> entityList1 =myService2.selectQnaMy(writer,start);
        List<CsCate3Entity> entityList2 =csService.selectCate3List();
        model.addAttribute("entityList1", entityList1);
        model.addAttribute("entityList2", entityList2);


        req.setAttribute("start", start);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("total", total);
        req.setAttribute("lastPageNum", lastPageNum);
        req.setAttribute("pageGroupCurrent", pageGroupCurrent);
        req.setAttribute("pageGroupStart", pageGroupStart);
        req.setAttribute("pageGroupEnd", pageGroupEnd);
        req.setAttribute("pageStartNum", pageStartNum);

        MemberEntity member=myService2.selectMyMember(writer);
        model.addAttribute("member", member);


        log.info(entityList2);
        log.info(entityList1);
        return "/my/qna";
    }
    @GetMapping("/my/review")
    public String review(Model model,HttpServletRequest req, String uid){

        String pg = req.getParameter("pg");


        //페이지 관련 변수
        int currentPage = (pg != null) ? Integer.parseInt(pg) : 1;
        int total = myService2.selectMyReviewCount(uid);
        int start = (currentPage - 1) * 10;
        int lastPageNum = (int) Math.ceil(total / 10.0);
        int pageGroupCurrent = (int) Math.ceil(currentPage / 10.0);
        int pageGroupStart = (pageGroupCurrent - 1) * 10 + 1;
        int pageGroupEnd = Math.min(pageGroupCurrent * 10, lastPageNum);
        int pageStartNum = total - start;

        List<ProductReviewDTO> entityList1 =myService2.selectMyReview(uid,start);
        model.addAttribute("entityList1", entityList1);

        req.setAttribute("start", start);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("total", total);
        req.setAttribute("lastPageNum", lastPageNum);
        req.setAttribute("pageGroupCurrent", pageGroupCurrent);
        req.setAttribute("pageGroupStart", pageGroupStart);
        req.setAttribute("pageGroupEnd", pageGroupEnd);
        req.setAttribute("pageStartNum", pageStartNum);


        return "/my/review";
    }


}
