package com.example.webSale.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "dbo",name = "category")
@Getter
@Setter
public class CategoryEntity extends BaseEntity implements Serializable {
    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "groupCategory_id")
    private GroupCategoryEntity groupCategoryId;

    @OneToMany(mappedBy = "categoryId")
    List<ProductEntity> products = new ArrayList<>();

}
