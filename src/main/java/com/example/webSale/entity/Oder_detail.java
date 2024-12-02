package com.example.webSale.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(schema = "dbo",name = "oder_detail")
@Getter
@Setter
public class Oder_detail extends BaseEntity implements Serializable {
    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private float price;

}
