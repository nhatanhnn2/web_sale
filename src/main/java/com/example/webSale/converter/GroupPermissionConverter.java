package com.example.webSale.converter;

import com.example.webSale.dto.GroupPermissionDTO;
import com.example.webSale.entity.GroupPermissionEntity;
import org.springframework.stereotype.Component;

@Component
public class GroupPermissionConverter {

    public GroupPermissionDTO toDTO(GroupPermissionEntity group_permission){
        GroupPermissionDTO dto = new GroupPermissionDTO();
        dto.setId(group_permission.getId());
        dto.setName(group_permission.getName());
        return dto;
    }

    public GroupPermissionEntity toEntity(GroupPermissionDTO dto){
      GroupPermissionEntity groupPermissionEntity = new GroupPermissionEntity();
        groupPermissionEntity.setId(dto.getId());
        groupPermissionEntity.setName(dto.getName());
        return groupPermissionEntity;
    }
}
