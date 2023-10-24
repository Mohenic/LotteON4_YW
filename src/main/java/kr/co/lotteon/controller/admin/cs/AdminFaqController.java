package kr.co.lotteon.controller.admin.cs;

import kr.co.lotteon.dto.cs.CsCate3DTO;
import kr.co.lotteon.entity.cs.CsCate3Entity;
import kr.co.lotteon.service.admin.cs.AdminFaqService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Log4j2
public class AdminFaqController {

    @Autowired
    private AdminFaqService service;

    @GetMapping("/admin/cs/faq/list")
    public String FaqList(){
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

}
