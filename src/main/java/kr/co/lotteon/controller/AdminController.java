package kr.co.lotteon.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.lotteon.dto.product.ProductDTO;
import kr.co.lotteon.entity.product.ProductCate1Entity;
import kr.co.lotteon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value = {"/admin", "/admin/index"})
    public String index(){
        return "/admin/index";
    }
    @GetMapping("/admin/product/register")
    public String register(){

        return "/admin/product/register";
    }

    @PostMapping("/admin/product/register")
    public String register(HttpServletRequest request, ProductDTO dto){

        dto.setIp(request.getRemoteAddr());
        adminService.save(dto);

        return "redirect:/admin/product/list";
    }

}
