package com.example.webSale.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "dbo",name = "group_category")
@Getter
@Setter
public class GroupCategoryEntity extends BaseEntity implements Serializable {
    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "groupCategoryId")
    List<CategoryEntity> categoryList = new ArrayList<>();
}
