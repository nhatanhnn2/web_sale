package com.example.webSale.converter;

import com.example.webSale.dto.Group_permissionDTO;
import com.example.webSale.entity.Group_permission;
import org.springframework.stereotype.Component;

@Component
public class Group_permissionConverter {

    public Group_permissionDTO toDTO(Group_permission group_permission){
        Group_permissionDTO dto = new Group_permissionDTO();
        dto.setId(group_permission.getId());
        dto.setName(group_permission.getName());
        return dto;
    }

    public Group_permission toEntity(Group_permissionDTO dto){
      Group_permission group_permission = new Group_permission();
      group_permission.setId(dto.getId());
      group_permission.setName(dto.getName());
      return group_permission;
    }
}
