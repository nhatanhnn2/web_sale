package com.example.webSale.converter;

import com.example.webSale.dto.RoleDTO;
import com.example.webSale.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    public RoleDTO toDTO(RoleEntity roleEntity){
        RoleDTO dto = new RoleDTO();
        dto.setId(roleEntity.getId());
        dto.setName(roleEntity.getName());
        return dto;
    }

    public RoleEntity toEntity(RoleDTO dto){
      RoleEntity roleEntity = new RoleEntity();
      roleEntity.setId(dto.getId());
      roleEntity.setName(dto.getName());
      return roleEntity;
    }
}
