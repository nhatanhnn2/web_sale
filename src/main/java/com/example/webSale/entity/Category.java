package com.example.webSale.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(schema = "dbo",name = "category")
@Getter
@Setter
public class Category extends BaseEntity implements Serializable {
    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private int status;

}
