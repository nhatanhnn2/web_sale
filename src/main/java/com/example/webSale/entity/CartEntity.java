package com.example.webSale.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "dbo",name = "cart")
@Getter
@Setter
public class CartEntity extends BaseEntity implements Serializable {
    @Column(name = "add_date")
    private Date addDate;

}
