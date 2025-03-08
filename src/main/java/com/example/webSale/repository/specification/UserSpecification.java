package com.example.webSale.repository.specification;

import com.example.webSale.dto.UsersDTO;
import com.example.webSale.entity.UsersEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class UserSpecification {

    public static Specification<UsersEntity> filterUser(UsersDTO usersDTO){
        return Specification.where(withEmail(usersDTO.getEmail()))
                .and(withName(usersDTO.getName()))
                .and(withStatus(usersDTO.getStatus()));
    }

    private static Specification<UsersEntity> withEmail(String email){
        if (StringUtils.isEmpty(email)){
            return null;
        }
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("email"),"%" +email +"%");
    }

    private static Specification<UsersEntity> withName(String name){
        if (StringUtils.isEmpty(name)) return null;
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"),"%" +name +"%");
    }

    private static Specification<UsersEntity> withStatus(Integer status){
        if (Objects.isNull(status)) return null;
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"),status);
    }
}
