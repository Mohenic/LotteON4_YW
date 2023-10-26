package kr.co.lotteon.controller.company;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.company.CompanyNoticeDTO;
import kr.co.lotteon.service.company.CompanyNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    private CompanyNoticeService service;

    @GetMapping(value = {"/company", "/company/index"})
    public String index(){
        return "/company/index";
    }

    @GetMapping("/company/introduce")
    public String introduce(){
        return "/company/introduce";
    }

    @GetMapping("/company/notice/list")
    public String noticeList(HttpServletRequest req, Model model){

        String pg = req.getParameter("pg");

        // 페이지 관련 변수
        int currentPage = (pg != null) ? Integer.parseInt(pg) : 1;
        int total = service.selectCountTotal();
        int start = (currentPage - 1) * 10;
        int lastPageNum = (int) Math.ceil(total / 10.0);
        int pageGroupCurrent = (int) Math.ceil(currentPage / 10.0);
        int pageGroupStart = (pageGroupCurrent - 1) * 10 + 1;
        int pageGroupEnd = Math.min(pageGroupCurrent * 10, lastPageNum);
        int pageStartNum = total - start;

        // 공시목록 조회
        List<CompanyNoticeDTO> lists = service.comNoticeList(start);


        // 모델에 속성 추가
        model.addAttribute("lists", lists);
        req.setAttribute("start", start);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("total", total);
        req.setAttribute("lastPageNum", lastPageNum);
        req.setAttribute("pageGroupCurrent", pageGroupCurrent);
        req.setAttribute("pageGroupStart", pageGroupStart);
        req.setAttribute("pageGroupEnd", pageGroupEnd);
        req.setAttribute("pageStartNum", pageStartNum);

        return "/company/notice/list";
    }

    @GetMapping("/company/notice/view")
    public String noticeView(Model model, int no){
        CompanyNoticeDTO view = service.comNoticeView(no);
        model.addAttribute("view",view);
        return "/company/notice/view";
    }

    @GetMapping("/company/promote")
    public String promote(){
        return "/company/promote";
    }

    @GetMapping("/company/manage")
    public String manage(){
        return "/company/manage";
    }
}
