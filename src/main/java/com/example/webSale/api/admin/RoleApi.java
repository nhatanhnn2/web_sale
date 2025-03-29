package com.example.webSale.api.admin;

import com.example.webSale.dto.RoleDTO;
import com.example.webSale.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/role")
public class RoleApi {
    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/getAll")
    public List<RoleDTO> getAll (){
        return roleService.getAllRole();
    }

}
