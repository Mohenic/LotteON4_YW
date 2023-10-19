package kr.co.lotteon.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.cs.CsArticleNoticeDTO;
import kr.co.lotteon.service.admin.AdminCSService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Log4j2
@Controller
public class AdminCSController {

    @Autowired
    private AdminCSService service;

    @GetMapping("/admin/cs/notice/list")
    public String noticeList(Model model, HttpServletRequest req, String cate2){

        // 값 요청

        String pg = req.getParameter("pg");

        //페이지 관련 변수
        int start=0;
        int currentPage =1;
        int total=0;
        int lastPageNum=0;
        int pageGroupCurrent=1;
        int pageGroupStart=1;
        int pageGroupEnd=0;
        int pageStartNum=0;


        //현재페이지계산
        if(pg!=null){
            currentPage =Integer.parseInt(pg);

        }

        //전체상품 갯수조회
        total=service.selectCountTotal();

        //LIMIT 시작값계산
        start =(currentPage -1)*10;


        if(total%10 == 0){
            lastPageNum =(total/10);
        }else{
            lastPageNum =(total/10)+1;
        }

        //페이지 그룹계산
        pageGroupCurrent=(int) Math.ceil(currentPage/10.0);
        pageGroupStart=(pageGroupCurrent-1)*10+1;
        pageGroupEnd=pageGroupCurrent*10;

        if(pageGroupEnd > lastPageNum){
            pageGroupEnd=lastPageNum;
        }

        //페이지 시작번호 계산
        pageStartNum = total-start;


        List<CsArticleNoticeDTO> lists = null;

        if (cate2 != null) {
            switch (cate2) {
                case "cs":
                    lists = service.NoticeListcs(start);
                    break;
                case "safety":
                    lists = service.NoticeListsafety(start);
                    break;
                case "danger":
                    lists = service.NoticeListdanger(start);
                    break;
                case "everesult":
                    lists = service.NoticeListeveresult(start);
                    break;
            }
        } else {
            lists = service.selectNoticeList(start);
        }

        model.addAttribute("lists",lists);

        return "/admin/cs/notice/list";
    }

}
