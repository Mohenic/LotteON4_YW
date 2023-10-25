package kr.co.lotteon.controller.admin.cs;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.cs.CsArticleFaqDTO;
import kr.co.lotteon.dto.cs.CsArticleNoticeDTO;
import kr.co.lotteon.dto.cs.CsCate3DTO;
import kr.co.lotteon.entity.cs.CsCate2Entity;
import kr.co.lotteon.entity.cs.CsCate3Entity;
import kr.co.lotteon.service.CsService;
import kr.co.lotteon.service.admin.cs.AdminFaqService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Log4j2
public class AdminFaqController {

    @Autowired
    private AdminFaqService service;
    @Autowired
    private CsService csService;

    @GetMapping("/admin/cs/faq/list")
    public String FaqList(HttpServletRequest req, Model model) {

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

        List<CsArticleFaqDTO> lists = null;

        if (cate2 == null && type == null) {
            lists = service.faqListAll(start);
        } else {
            lists = service.faqListCate(cate2, type, start);
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

        return "/admin/cs/faq/list";
    }

    @GetMapping("/admin/cs/faq/listType")
    @ResponseBody
    public List<CsCate3Entity> faqListType(@RequestParam("cate2") String cate2) {

        log.info("selectValue : " + cate2);

        List<CsCate3Entity> listType = service.faqListType(cate2);

        log.info("listType : " + listType);

        return listType;
    }

    @GetMapping("/admin/cs/faq/delete")
    public String faqListDelete(@RequestParam("chk") List<Integer> Nos){
        int deletedCount = service.faqListDelete(Nos);
        return "redirect:/admin/cs/faq/list";
    }

    @GetMapping("/admin/cs/faq/view")
    public String faqView(Model model, int no){

        CsArticleFaqDTO view = service.faqView(no);
        List<CsCate2Entity> entity2 = csService.selectCate2Detail();
        List<CsCate3Entity> entity3 = csService.selectCate3List();

        model.addAttribute("view", view);
        model.addAttribute("cate2", entity2);
        model.addAttribute("cate3", entity3);

        return "/admin/cs/faq/view";
    }

    @GetMapping("/admin/cs/faq/write")
    public String faqWrite(){

        return "/admin/cs/faq/write";
    }

    @PostMapping("/admin/cs/faq/write")
    public String faqWrite(HttpServletRequest req,CsArticleFaqDTO dto){
        String regip = req.getRemoteAddr();
        service.faqWrite(dto,regip);

        return "redirect:/admin/cs/faq/list";
    }

    @GetMapping("/admin/cs/faq/modify")
    public String faqModify(Model model, int no){
        CsArticleFaqDTO modList = service.faqView(no);
        model.addAttribute("modList", modList);
        model.addAttribute("no", no);
        return "/admin/cs/faq/modify";
    }

    @PostMapping("/admin/cs/faq/modify")
    public String faqModfiy(HttpServletRequest req, CsArticleFaqDTO dto){

        int no = Integer.parseInt(req.getParameter("no"));
        String regip = req.getRemoteAddr();

        log.info("dto: " + dto);

        service.faqModify(dto,regip,no);

        return "redirect:/admin/cs/faq/view?no="+no;
    }
}
