package com.example.webSale.converter;

import com.example.webSale.dto.PermissionDTO;

import com.example.webSale.entity.Permission;
import org.springframework.stereotype.Component;

@Component
public class PermissionConverter {

    public PermissionDTO toDTO(Permission permission){
        PermissionDTO dto = new PermissionDTO();
        dto.setId(permission.getId());
        dto.setName(permission.getName());
        return dto;
    }

    public Permission toEntity(PermissionDTO dto){
      Permission permission = new Permission();
      permission.setId(dto.getId());
      permission.setName(dto.getName());
      return permission;
    }
}
