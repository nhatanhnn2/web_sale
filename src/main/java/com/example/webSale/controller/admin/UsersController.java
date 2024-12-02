package com.example.webSale.controller.admin;

import com.example.webSale.dto.UsersDTO;
import com.example.webSale.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("users-list")
    public String getAll(Model model){
        List<UsersDTO> usersDTOS = usersService.getAllUser();
        model.addAttribute("users",usersDTOS);
        return "Account/AccountList";
    }
}
