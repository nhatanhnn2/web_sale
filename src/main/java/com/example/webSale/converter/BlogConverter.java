package com.example.webSale.converter;

import com.example.webSale.dto.BlogDTO;
import com.example.webSale.dto.CartDTO;
import com.example.webSale.entity.Blog;
import com.example.webSale.entity.Cart;
import org.springframework.stereotype.Component;

@Component
public class BlogConverter {

    public BlogDTO toDTO(Blog blog){
        BlogDTO dto = new BlogDTO();
        dto.setId(blog.getId());
        dto.setContent(blog.getContent());
        dto.setDescription(blog.getDescription());
        return dto;
    }

    public Blog toEntity(BlogDTO dto){
        Blog blog = new Blog();
        blog.setId(dto.getId());
        blog.setContent(dto.getContent());
        blog.setDescription(dto.getDescription());
        return blog;
    }
}
