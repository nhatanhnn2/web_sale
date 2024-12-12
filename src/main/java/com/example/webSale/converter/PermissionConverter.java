package com.example.webSale.converter;

import com.example.webSale.dto.PermissionDTO;

import com.example.webSale.entity.PermissionEntity;
import org.springframework.stereotype.Component;

@Component
public class PermissionConverter {

    public PermissionDTO toDTO(PermissionEntity permissionEntity){
        PermissionDTO dto = new PermissionDTO();
        dto.setId(permissionEntity.getId());
        dto.setName(permissionEntity.getName());
        return dto;
    }

    public PermissionEntity toEntity(PermissionDTO dto){
      PermissionEntity permissionEntity = new PermissionEntity();
      permissionEntity.setId(dto.getId());
      permissionEntity.setName(dto.getName());
      return permissionEntity;
    }
}
