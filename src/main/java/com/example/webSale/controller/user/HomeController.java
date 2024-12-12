package com.example.webSale.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "web")
public class HomeController {
    @GetMapping("/dang-nhap")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");

        return mav;
    }
}
