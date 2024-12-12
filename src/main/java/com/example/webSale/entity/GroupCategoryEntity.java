package com.example.webSale.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(schema = "dbo",name = "group_category")
@Getter
@Setter
public class GroupCategoryEntity extends BaseEntity implements Serializable {
    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private int status;

}
