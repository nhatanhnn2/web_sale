package com.example.webSale.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "dbo",name = "oder")
@Getter
@Setter
public class Oder extends BaseEntity implements Serializable {
    @Column(name = "oder_date")
    private Date oder_date;

    @Column(name = "adderss")
    private String adderss;

}
