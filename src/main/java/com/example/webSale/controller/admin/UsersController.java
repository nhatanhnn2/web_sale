package com.example.webSale.controller.admin;

import com.example.webSale.dto.UsersDTO;
import com.example.webSale.entity.RoleEntity;
import com.example.webSale.repository.RoleRepository;
import com.example.webSale.service.UsersService;
import com.example.webSale.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UsersController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/user/list")
    public ModelAndView listUser(){
        ModelAndView mav = new ModelAndView("admin/user");
        mav.addObject("roles", SecurityUtils.getAuthorities());
        return mav;
    }

    @GetMapping("user/edit-profile/{id}")
    public ModelAndView editUser(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("admin/editUser");
        mav.addObject("roles", SecurityUtils.getAuthorities());
        mav.addObject("userId", id);
        return mav;
    }

    @GetMapping("/createUser")
    public ModelAndView showCreateUserForm() {
        ModelAndView mav = new ModelAndView("admin/createUser");

        // Lấy danh sách roles từ database
        List<RoleEntity> roles = roleRepository.findAll();

        // Thêm danh sách roles vào Model
        mav.addObject("roles", roles);
        mav.addObject("user", new UsersDTO());

        return mav;
    }


}
