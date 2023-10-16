package kr.co.lotteon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping(value = {"/admin", "/admin/index"})
    public String index(){
        return "/admin/index";
    }
    @GetMapping("/admin/product/register")
    public String register(){
        return "/admin/product/register";
    }

}
