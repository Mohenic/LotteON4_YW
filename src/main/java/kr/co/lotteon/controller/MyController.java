package kr.co.lotteon.controller;




import kr.co.lotteon.dto.my.*;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.MemberDTO;
import kr.co.lotteon.entity.cs.CsArticleQnaEntity;
import kr.co.lotteon.service.MyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
public class MyController {
    @Autowired
    private BuildProperties buildProperties; // 빌드 정보를 갖는 객체 주입

    @Autowired
    private MyService myService; // �


    @ModelAttribute("appInfo")
    public String appversion(){
        String appName = buildProperties.getName(); // settings.gradle 파일에서 앱이름 가져옴
        String version = buildProperties.getVersion(); // build.gradle 파일에서 버전값 가져옴
        return appName+version;
    }
    @ModelAttribute("myInfo")
    public MyInfoDTO myinfo(@RequestParam("uid") String uid){
        log.info("uid : "+uid);
        MyInfoDTO member = myService.findMyInfo(uid);
        log.info("member : "+member);
         return member;
    }

   /* @GetMapping("/my/home")
    public String home(Model model){
        return "/my/home";
    }*/
    /*@GetMapping("/my/coupon")
    public String coupon(Model model){
        return "/my/coupon";
    }*/
    @GetMapping("/my/order")
    public String order(Model model, PageRequestOrderDTO pageRequestOrderDTO){
        PageResponseOrderDTO pageResponseOrderDTO = myService.order(pageRequestOrderDTO);
        model.addAttribute("orderDTO", pageResponseOrderDTO);
        return "/my/order";
    }
    @GetMapping("/my/point")
    public String point(Model model, PageRequestPointDTO pageRequestPointDTO){
        PageResponsePointDTO pageResponsePointDTO = myService.point(pageRequestPointDTO);
        model.addAttribute("pointDTO", pageResponsePointDTO);
        return "/my/point";
    }
   /* @GetMapping("/my/qna")
    public String qna(Model model ,String writer){
        List<CsArticleQnaEntity> entityList1 =myService.selectQnaMy(writer);

        model.addAttribute("entityList1", entityList1);
        return "/my/qna";
    }
    @GetMapping("/my/review")
    public String review(Model model){
        return "/my/review";
    }*/
}
