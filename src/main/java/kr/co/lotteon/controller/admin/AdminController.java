package kr.co.lotteon.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.admin.PageRequestDTO;
import kr.co.lotteon.dto.admin.PageResponseDTO;
import kr.co.lotteon.dto.product.ProductDTO;
import kr.co.lotteon.entity.product.ProductCate1Entity;
import kr.co.lotteon.entity.product.ProductCate2Entity;
import kr.co.lotteon.service.admin.AdminService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value = {"/admin", "/admin/index"})
    public String index(){
        return "/admin/index";
    }

    // product list

    @GetMapping("/admin/product/list")
    public String list(Model model, PageRequestDTO pageRequestDTO,String searchCate, String search){

        PageResponseDTO pageResponseDTO= null;

        if (searchCate != null) {
            switch (searchCate) {
                case "prodName":
                    pageResponseDTO = adminService.findByProdName(pageRequestDTO, search);
                    break;
                case "prodNo":
                    pageResponseDTO = adminService.findByProdNo(pageRequestDTO, Integer.parseInt(search));
                    break;
                case "company":
                    pageResponseDTO = adminService.findByCompany(pageRequestDTO, search);
                    break;
                case "seller":
                    pageResponseDTO = adminService.findBySeller(pageRequestDTO, search);
                    break;
            }
        } else {
            pageResponseDTO = adminService.findByUseyn(pageRequestDTO);
        }
            model.addAttribute("pageResponseDTO",pageResponseDTO);

        return "/admin/product/list";
    }

    // product register

    @GetMapping("/admin/product/register")
    public String register(Model model){

        List<ProductCate1Entity> setCate1 = adminService.cateList();

        log.info("setCate1 : " + setCate1);

        model.addAttribute("setCate1",setCate1);

        return "/admin/product/register";
    }

    @GetMapping("/admin/product/registerCate2")
    @ResponseBody
    public List<ProductCate2Entity> registerCate2(@RequestParam("selectValue") int selectValue) {

        log.info("setCate2 ..... ");
        log.info("selectValue : " + selectValue);

        List<ProductCate2Entity> cate2List = adminService.cate2List(selectValue);

        log.info("setCate2 : " + cate2List);

        return cate2List;
    }

    @PostMapping("/admin/product/register")
    public String register(HttpServletRequest request, ProductDTO dto){

        dto.setIp(request.getRemoteAddr());
        adminService.save(dto);

        return "redirect:/admin/product/list";
    }

    // product delete

    @GetMapping("/admin/product/delete")
    public String delete(@RequestParam("chk") List<Integer> prodNos){
        int deletedCount = adminService.deleteByProdNo(prodNos);
        return "redirect:/admin/product/list";
    }

    // product modify
    @GetMapping("/admin/product/modify")
    public String modify(Model model){

        List<ProductCate1Entity> setCate1 = adminService.cateList();

        log.info("setCate1 : " + setCate1);

        model.addAttribute("setCate1",setCate1);

        return "/admin/product/modify";
    }

    @GetMapping("/admin/product/modifyCate2")
    @ResponseBody
    public List<ProductCate2Entity> modifyCate2(@RequestParam("selectValue") int selectValue) {

        log.info("setCate2 ..... ");
        log.info("selectValue : " + selectValue);

        List<ProductCate2Entity> cate2List = adminService.cate2List(selectValue);

        log.info("setCate2 : " + cate2List);

        return cate2List;
    }

}