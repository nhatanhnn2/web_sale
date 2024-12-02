package com.example.webSale.converter;

import com.example.webSale.dto.RoleDTO;
import com.example.webSale.dto.UsersDTO;
import com.example.webSale.entity.Role;
import com.example.webSale.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    public RoleDTO toDTO(Role role){
        RoleDTO dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setName(role.getName());
        return dto;
    }

    public Role toEntity(RoleDTO dto){
      Role role = new Role();
      role.setId(dto.getId());
      role.setName(dto.getName());
      return role;
    }
}
