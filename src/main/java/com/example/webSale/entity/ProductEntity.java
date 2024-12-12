package com.example.webSale.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(schema = "dbo",name = "product")
@Getter
@Setter
public class ProductEntity extends BaseEntity implements Serializable {
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
    private float priceSale;

    @Column(name = "status")
    private int status;

    @Column(name = "image")
    private String image;

}
