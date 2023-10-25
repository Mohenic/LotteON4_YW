package kr.co.lotteon.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.PageRequestOrderDTO;
import kr.co.lotteon.dto.PageResponseOrderDTO;
import kr.co.lotteon.entity.cs.CsArticleQnaEntity;
import kr.co.lotteon.entity.cs.CsCate3Entity;
import kr.co.lotteon.entity.my.CouponEntity;
import kr.co.lotteon.service.CsService;
import kr.co.lotteon.service.MyService;
import kr.co.lotteon.service.MyService2;
import kr.co.lotteon.service.admin.AdminService;
import kr.co.lotteon.service.admin.cs.AdminNoticeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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

    @ModelAttribute("appInfo")
    public String appversion(){
        String appName = buildProperties.getName(); // settings.gradle 파일에서 앱이름 가져옴
        String version = buildProperties.getVersion(); // build.gradle 파일에서 버전값 가져옴
        return appName+version;
    }

    @GetMapping("/my/home")
    public String home(Model model){
        return "/my/home";
    }
    @GetMapping("/my/coupon")
    public String coupon(Model model, String uid){

        List<CouponEntity> entityList1=myService2.selectCoupon(uid);

        model.addAttribute("entityList1", entityList1);

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


        log.info(entityList2);
        log.info(entityList1);
        return "/my/qna";
    }
    @GetMapping("/my/review")
    public String review(Model model){
        return "/my/review";
    }
}
