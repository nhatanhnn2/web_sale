package com.example.webSale.converter;

import com.example.webSale.dto.GroupPermissionDTO;
import com.example.webSale.entity.GroupPermissionEntity;
import org.springframework.stereotype.Component;

@Component
public class GroupPermissionConverter {

    public GroupPermissionDTO toDTO(GroupPermissionEntity groupPermission){
        GroupPermissionDTO dto = new GroupPermissionDTO();
        dto.setId(groupPermission.getId());
        dto.setName(groupPermission.getName());
        dto.setCode(groupPermission.getCode());
        return dto;
    }

    public GroupPermissionEntity toEntity(GroupPermissionDTO dto){
      GroupPermissionEntity groupPermissionEntity = new GroupPermissionEntity();
        groupPermissionEntity.setId(dto.getId());
        groupPermissionEntity.setName(dto.getName());
        groupPermissionEntity.setCode(dto.getCode());
        return groupPermissionEntity;
    }
}
