package com.example.webSale.controller.admin;

import com.example.webSale.utils.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/admin")
public class BlogController {

    @GetMapping("/blog/list")
    public ModelAndView listBlog(){
        ModelAndView mav = new ModelAndView("admin/blog");
        mav.addObject("roles", SecurityUtils.getAuthorities());
        return mav;
    }

    @GetMapping("blog/edit-blog/{id}")
    public ModelAndView editBlog(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("admin/editBlog");
        mav.addObject("roles", SecurityUtils.getAuthorities());
        mav.addObject("blogId", id);
        return mav;
    }
}
