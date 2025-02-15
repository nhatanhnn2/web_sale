package com.example.webSale.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UsersDTO extends AbstractDto{
    private String email;
    private String phone;
    private String avatar;
    private Integer gender;
    private String password;
    private String name;
    private Integer status;
    private Long roleId;
}
