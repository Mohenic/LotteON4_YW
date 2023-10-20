package kr.co.lotteon.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.cs.CsArticleNoticeDTO;
import kr.co.lotteon.service.admin.AdminCSService;
import kr.co.lotteon.service.admin.AdminService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log4j2
@Controller
public class AdminCSController {

    @Autowired
    private AdminCSService service;

    // notice part

    @GetMapping("/admin/cs/notice/list")
    public String noticeList(Model model, HttpServletRequest req){

        // 값 요청

        String pg = req.getParameter("pg");
        String cate2 = req.getParameter("cate2");

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

        //전체 갯수조회
        if(cate2 == null) {
            total = service.selectCountTotal();
        } else {
            total = service.selectCountTotalCate(cate2);
        }


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

        log.info("cate2" + cate2);

        model.addAttribute("lists",lists);
        req.setAttribute("cate2",cate2);
        req.setAttribute("start", start);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("total", total);
        req.setAttribute("lastPageNum", lastPageNum);
        req.setAttribute("pageGroupCurrent", pageGroupCurrent);
        req.setAttribute("pageGroupStart", pageGroupStart);
        req.setAttribute("pageGroupEnd", pageGroupEnd);
        req.setAttribute("pageStartNum", pageStartNum);

        return "/admin/cs/notice/list";
    }

    @GetMapping("/admin/cs/notice/delete")
    public String noticeDelete(@RequestParam("chk") List<Integer> Nos){
        int deletedCount = service.deleteByNo(Nos);
        return "redirect:/admin/cs/notice/list";
    }
    @GetMapping("/admin/cs/notice/view")
    public String noticeView(Model model, int no){

        CsArticleNoticeDTO view = service.NoticeView(no);
        model.addAttribute("view", view);

        return "/admin/cs/notice/view";
    }

    @GetMapping("/admin/cs/notice/write")
    public String noticeWrite(){
        return "/admin/cs/notice/write";
    }

    @PostMapping("/admin/cs/notice/write")
    public String noticeWrite(HttpServletRequest req,CsArticleNoticeDTO dto){
        String regip = req.getRemoteAddr();
        log.info("dto : " + dto);
        service.NoticeWrite(dto,regip);
        log.info("service.NoticeWrite(dto,regip) : " + service.NoticeWrite(dto,regip));

        return "redirect:/admin/cs/notice/list";
    }

}
