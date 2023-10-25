package kr.co.lotteon.controller.admin.cs;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.cs.CsArticleNoticeDTO;
import kr.co.lotteon.entity.cs.CsCate2Entity;
import kr.co.lotteon.entity.cs.CsCate3Entity;
import kr.co.lotteon.service.CsService;
import kr.co.lotteon.service.admin.cs.AdminNoticeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Log4j2
@Controller
public class AdminNoticeController {

    @Autowired
    private AdminNoticeService service;
    @Autowired
    private CsService csService;

    // notice part

    @GetMapping("/admin/cs/notice/list")
    public String noticeList(Model model, HttpServletRequest req) {
        // 페이지 및 카테고리 정보 요청
        String pg = req.getParameter("pg");
        String cate2 = req.getParameter("cate2");
        List<CsCate3Entity> entity2 = csService.selectCate3List();

        // 페이지 관련 변수
        int currentPage = (pg != null) ? Integer.parseInt(pg) : 1;
        int total = (cate2 == null) ? service.selectCountTotal() : service.selectCountTotalCate(cate2);
        int start = (currentPage - 1) * 10;
        int lastPageNum = (int) Math.ceil(total / 10.0);
        int pageGroupCurrent = (int) Math.ceil(currentPage / 10.0);
        int pageGroupStart = (pageGroupCurrent - 1) * 10 + 1;
        int pageGroupEnd = Math.min(pageGroupCurrent * 10, lastPageNum);
        int pageStartNum = total - start;

        // 공지사항 목록 조회
        List<CsArticleNoticeDTO> lists;

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
                default:
                    lists = Collections.emptyList(); // 기본값 설정
                    break;
            }
        } else {
            lists = service.selectNoticeList(start);
        }

        // 모델에 속성 추가
        model.addAttribute("lists", lists);
        model.addAttribute("entity2", entity2);
        req.setAttribute("cate2", cate2);
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
        List<CsCate2Entity> entity2 = csService.selectCate2Detail();
        model.addAttribute("view", view);
        model.addAttribute("cate2", entity2);

        return "/admin/cs/notice/view";
    }

    @GetMapping("/admin/cs/notice/write")
    public String noticeWrite(){

        return "/admin/cs/notice/write";
    }

    @PostMapping("/admin/cs/notice/write")
    public String noticeWrite(HttpServletRequest req,CsArticleNoticeDTO dto){
        String regip = req.getRemoteAddr();
        service.NoticeWrite(dto,regip);

        return "redirect:/admin/cs/notice/list";
    }
    @GetMapping("/admin/cs/notice/modify")
    public String noticeModify(Model model, int no){
        CsArticleNoticeDTO modList = service.NoticeView(no);
        model.addAttribute("modList", modList);
        model.addAttribute("no", no);
        return "/admin/cs/notice/modify";
    }
    @PostMapping("/admin/cs/notice/modify")
    public String noticeModfiy(HttpServletRequest req, CsArticleNoticeDTO dto){

        int no = Integer.parseInt(req.getParameter("no"));
        String regip = req.getRemoteAddr();

        log.info("dto: " + dto);

        service.NoticeModify(dto,regip,no);

        return "redirect:/admin/cs/notice/view?no="+no;
    }

}
