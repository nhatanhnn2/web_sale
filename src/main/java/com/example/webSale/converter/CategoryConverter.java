package com.example.webSale.converter;

import com.example.webSale.dto.CategoryDTO;
import com.example.webSale.dto.Group_categoryDTO;
import com.example.webSale.entity.Category;
import com.example.webSale.entity.Group_category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryDTO toDTO(Category category){
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setStatus(category.getStatus());
        return dto;
    }

    public Category toEntity(CategoryDTO dto){
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        category.setStatus(dto.getStatus());
        return category;
    }
}
