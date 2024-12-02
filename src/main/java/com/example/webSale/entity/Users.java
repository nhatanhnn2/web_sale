package com.example.webSale.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(schema = "dbo",name = "users")
@Getter
@Setter
public class Users extends BaseEntity implements Serializable {
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "gender")
    private String gender;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private Integer status;

//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private RoleEntity roleId;
}