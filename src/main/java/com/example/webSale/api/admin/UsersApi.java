package com.example.webSale.api.admin;

import com.example.webSale.dto.UsersDTO;
import com.example.webSale.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/api/user")
public class UsersApi {
    @Autowired
    private UsersService usersService;

    @PostMapping()
    public UsersDTO create(@RequestBody UsersDTO usersDto) throws Exception{
        return usersService.create(usersDto);
    }
//    @PutMapping()
//    public UsersDTO update(@RequestBody UsersDTO usersDto){
//        return usersService.create(usersDto);
//    }

}
