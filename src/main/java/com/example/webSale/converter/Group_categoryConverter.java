package com.example.webSale.converter;

import com.example.webSale.dto.Group_categoryDTO;
import com.example.webSale.dto.Group_permissionDTO;
import com.example.webSale.entity.Group_category;
import com.example.webSale.entity.Group_permission;
import org.springframework.stereotype.Component;

@Component
public class Group_categoryConverter {

    public Group_categoryDTO toDTO(Group_category group_category){
        Group_categoryDTO dto = new Group_categoryDTO();
        dto.setId(group_category.getId());
        dto.setName(group_category.getName());
        dto.setStatus(group_category.getStatus());
        return dto;
    }

    public Group_category toEntity(Group_categoryDTO dto){
        Group_category group_category = new Group_category();
      group_category.setId(dto.getId());
      group_category.setName(dto.getName());
      group_category.setStatus(dto.getStatus());
      return group_category;
    }
}
