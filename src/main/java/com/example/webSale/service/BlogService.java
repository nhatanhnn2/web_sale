package com.example.webSale.service;

import com.example.webSale.dto.BlogDTO;
import com.example.webSale.dto.ResponseDTO;
import com.example.webSale.dto.UsersDTO;
import com.example.webSale.entity.BlogEntity;

public interface BlogService {
    ResponseDTO<BlogDTO> getAllBlog(BlogDTO dto);
    BlogDTO findById (Long id);
}
