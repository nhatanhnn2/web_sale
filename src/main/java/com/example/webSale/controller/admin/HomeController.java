package com.example.webSale.controller.admin;

import com.example.webSale.utils.SecurityUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller(value = "admin")
@RequestMapping("/admin")
public class HomeController {
    @GetMapping("/home")
    public ModelAndView homeAdmin(){
        ModelAndView mav = new ModelAndView("admin/home");
        return mav;
    }
}
