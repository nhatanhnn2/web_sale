package com.example.webSale.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "dbo",name = "permission")
@Getter
@Setter
public class PermissionEntity extends BaseEntity implements Serializable {
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;


    @ManyToMany(mappedBy = "permissionEntities")
    private List<GroupPermissionEntity> groupPmEntities = new ArrayList<>();

}
