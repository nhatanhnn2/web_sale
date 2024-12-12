package com.example.webSale.converter;

import com.example.webSale.dto.UsersDTO;
import com.example.webSale.entity.UsersEntity;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter {

    public UsersDTO toDTO(UsersEntity usersEntity){
        UsersDTO dto = new UsersDTO();
        dto.setId(usersEntity.getId());
        dto.setName(usersEntity.getName());
        dto.setAddress(usersEntity.getAddress());
        dto.setPhone(usersEntity.getPhone());
        dto.setEmail(usersEntity.getEmail());
        dto.setAvatar(usersEntity.getAvatar());
        dto.setGender(usersEntity.getGender());
        return dto;
    }

    public UsersEntity toEntity(UsersDTO dto){
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(dto.getId());
        usersEntity.setEmail(dto.getEmail());
        usersEntity.setName(dto.getName());
        usersEntity.setAddress(dto.getAddress());
        usersEntity.setPhone(dto.getPhone());
        usersEntity.setAvatar(dto.getAvatar());
        usersEntity.setGender(dto.getGender());
        return usersEntity;
    }
}
