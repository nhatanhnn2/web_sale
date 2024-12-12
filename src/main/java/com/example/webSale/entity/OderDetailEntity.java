package com.example.webSale.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(schema = "dbo",name = "oder_detail")
@Getter
@Setter
public class OderDetailEntity extends BaseEntity implements Serializable {
    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private float price;

}
