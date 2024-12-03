package com.example.webSale.converter;

import com.example.webSale.dto.CategoryDTO;
import com.example.webSale.dto.CommentDTO;
import com.example.webSale.entity.Category;
import com.example.webSale.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {

    public CommentDTO toDTO(Comment comment){
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setContent(comment.getContent());
        return dto;
    }

    public Comment toEntity(CommentDTO dto){
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setContent(dto.getContent());
        return comment;
    }
}
