package com.example.webSale.api.admin;

import com.example.webSale.dto.ResponseDTO;
import com.example.webSale.dto.UsersDTO;
import com.example.webSale.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api/user")
public class UsersApi {
    @Autowired
    private UsersService usersService;

    @PostMapping()
    public UsersDTO create(@RequestBody UsersDTO usersDto) throws Exception{
        return usersService.create(usersDto);
    }
    @PutMapping()
    public UsersDTO update(@RequestBody UsersDTO usersDto)throws Exception{
        return usersService.update(usersDto);
    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDTO<UsersDTO>> listUser(@RequestBody UsersDTO usersDto){
        return new ResponseEntity<>(usersService.getAllUser(usersDto), HttpStatus.OK);
    }

}
