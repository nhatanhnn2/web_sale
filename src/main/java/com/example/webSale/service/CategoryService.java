package com.example.webSale.service;

import com.example.webSale.dto.CategoryDTO;
import com.example.webSale.dto.ResponseDTO;


public interface CategoryService {
    ResponseDTO<CategoryDTO> getAllCategory(CategoryDTO dto);
    CategoryDTO create(CategoryDTO dto) throws Exception;
    CategoryDTO update(CategoryDTO dto) throws Exception;
}
