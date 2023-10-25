package kr.co.lotteon.controller.admin.cs;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.cs.CsArticleFaqDTO;
import kr.co.lotteon.dto.cs.CsArticleQnaDTO;
import kr.co.lotteon.entity.cs.CsCate2Entity;
import kr.co.lotteon.entity.cs.CsCate3Entity;
import kr.co.lotteon.service.CsService;
import kr.co.lotteon.service.admin.cs.AdminQnaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Log4j2
public class AdminQnaController {

    @Autowired
    private AdminQnaService service;
    @Autowired
    private CsService csService;

    @GetMapping("/admin/cs/qna/list")
    public String qnaList(HttpServletRequest req, Model model){
        String pg = req.getParameter("pg");
        String cate2 = req.getParameter("cate2");
        String type = req.getParameter("type");

        // 페이지 관련 변수
        int currentPage = (pg != null) ? Integer.parseInt(pg) : 1;
        int total = (cate2 == null && type == null) ? service.selectCountTotal() : service.selectCountTotalCate(cate2, type);
        int start = (currentPage - 1) * 10;
        int lastPageNum = (int) Math.ceil(total / 10.0);
        int pageGroupCurrent = (int) Math.ceil(currentPage / 10.0);
        int pageGroupStart = (pageGroupCurrent - 1) * 10 + 1;
        int pageGroupEnd = Math.min(pageGroupCurrent * 10, lastPageNum);
        int pageStartNum = total - start;

        List<CsCate3Entity> entity3 = csService.selectCate3List();
        List<CsCate2Entity> entity2 = csService.selectCate2Detail();

        List<CsArticleQnaDTO> lists = null;

        if (cate2 == null && type == null) {
            lists = service.qnaListAll(start);
        } else {
            lists = service.qnaListCate(cate2, type, start);
        }

        log.info("lists : " + lists);

        model.addAttribute("lists", lists);
        model.addAttribute("entity2", entity2);
        model.addAttribute("entity3", entity3);
        req.setAttribute("cate2", cate2);
        req.setAttribute("type", type);
        req.setAttribute("start", start);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("total", total);
        req.setAttribute("lastPageNum", lastPageNum);
        req.setAttribute("pageGroupCurrent", pageGroupCurrent);
        req.setAttribute("pageGroupStart", pageGroupStart);
        req.setAttribute("pageGroupEnd", pageGroupEnd);
        req.setAttribute("pageStartNum", pageStartNum);

        return "/admin/cs/qna/list";
    }

    @GetMapping("/admin/cs/qna/delete")
    public String qnaListDelete(@RequestParam("chk") List<Integer> Nos){
        int deletedCount = service.qnaListDelete(Nos);
        return "redirect:/admin/cs/qna/list";
    }

    @GetMapping("/admin/cs/qna/view")
    public String qnaView(Model model, int no){

        CsArticleQnaDTO view = service.qnaView(no);
        CsArticleQnaDTO reply = service.qnaReplyView(no);
        List<CsCate2Entity> entity2 = csService.selectCate2Detail();
        List<CsCate3Entity> entity3 = csService.selectCate3List();

        model.addAttribute("view", view);
        model.addAttribute("reply", reply);
        model.addAttribute("cate2", entity2);
        model.addAttribute("cate3", entity3);

        return "/admin/cs/qna/view";
    }

    @PostMapping("/admin/cs/qna/reply")
    public String qnaReply(HttpServletRequest req, @RequestParam("parent") int parent,
                                                   @RequestParam("cate1") String cate1,
                                                   @RequestParam("content") String content,
                                                    @RequestParam("writer") String writer){

        String regip = req.getRemoteAddr();
        service.qnaReplyAndCommentUpdate(parent,cate1,content,writer,regip);

        return "redirect:/admin/cs/qna/view?no=" + parent;
    }
}
