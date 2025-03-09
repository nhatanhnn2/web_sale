package com.example.webSale.controller.admin;

import com.example.webSale.dto.UsersDTO;
import com.example.webSale.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UsersController {

    @GetMapping("/user/list")
    public ModelAndView homeAdmin(){
        ModelAndView mav = new ModelAndView("admin/user");
        return mav;
    }
}
