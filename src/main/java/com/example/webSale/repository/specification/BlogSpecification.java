package com.example.webSale.repository.specification;

import com.example.webSale.dto.BlogDTO;
import com.example.webSale.entity.BlogEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;


public class BlogSpecification {

    public static Specification<BlogEntity> filterblog(BlogDTO blogDTO){
        return Specification.where(withContent(blogDTO.getContent()))
                .and(withDescription(blogDTO.getDescription()));
    }

    private static Specification<BlogEntity> withContent(String content){
        if (StringUtils.isEmpty(content)){
            return null;
        }
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("content"),"%" +content +"%");
    }

    private static Specification<BlogEntity> withDescription(String description){
        if (StringUtils.isEmpty(description)) return null;
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("description"),"%" +description +"%");
    }

}
