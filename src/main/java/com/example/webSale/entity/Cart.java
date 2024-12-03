package com.example.webSale.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "dbo",name = "cart")
@Getter
@Setter
public class Cart extends BaseEntity implements Serializable {
    @Column(name = "add_date")
    private Date add_date;

}
