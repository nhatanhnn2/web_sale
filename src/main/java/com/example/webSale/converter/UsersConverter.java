package com.example.webSale.converter;

import com.example.webSale.dto.UsersDTO;
import com.example.webSale.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter {

    public UsersDTO toDTO(Users users){
        UsersDTO dto = new UsersDTO();
        dto.setId(users.getId());
        dto.setName(users.getName());
        dto.setAddress(users.getAddress());
        dto.setPhone(users.getPhone());
        dto.setEmail(users.getEmail());
        dto.setAvatar(users.getAvatar());
        dto.setGender(users.getGender());
        return dto;
    }

    public Users toEntity(UsersDTO dto){
        Users users = new Users();
        users.setId(dto.getId());
        users.setEmail(dto.getEmail());
        users.setName(dto.getName());
        users.setAddress(dto.getAddress());
        users.setPhone(dto.getPhone());
        users.setAvatar(dto.getAvatar());
        users.setGender(dto.getGender());
        return users;
    }
}
