package kr.co.lotteon.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.product.ProductCate1DTO;
import kr.co.lotteon.dto.product.ProductCate2DTO;
import kr.co.lotteon.dto.product.ProductDTO;
import kr.co.lotteon.entity.product.ProductCate1Entity;
import kr.co.lotteon.entity.product.ProductCate2Entity;
import kr.co.lotteon.service.AdminService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        List<ProductCate2Entity> cate2List = adminService.cate2List(selectValue);
        return cate2List;
    }

    @PostMapping("/admin/product/register")
    public String register(HttpServletRequest request, ProductDTO dto){

        dto.setIp(request.getRemoteAddr());
        adminService.save(dto);

        return "redirect:/admin/product/list";
    }

}
