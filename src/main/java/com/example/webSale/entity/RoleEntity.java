package com.example.webSale.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "dbo",name = "role")
@Getter
@Setter
public class RoleEntity extends BaseEntity implements Serializable {
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;


    @OneToMany(mappedBy = "roleId")
    List<UsersEntity> users = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "role_group",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<GroupPermissionEntity> groupPmEntities = new ArrayList<>();

}
