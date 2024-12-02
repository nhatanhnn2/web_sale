package com.example.webSale.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(schema = "dbo",name = "product")
@Getter
@Setter
public class Product extends BaseEntity implements Serializable {
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "price_sale")
    private float price_sale;

    @Column(name = "status")
    private int status;

    @Column(name = "image")
    private String image;

}
