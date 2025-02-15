package com.example.webSale.entity;
;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "dbo",name = "group_pm")
@Getter
@Setter
public class GroupPermissionEntity extends BaseEntity implements Serializable {
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @ManyToMany(mappedBy = "groupPmEntities")
    List<RoleEntity> roles = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "group_permission",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<PermissionEntity> permissionEntities = new ArrayList<>();
}
