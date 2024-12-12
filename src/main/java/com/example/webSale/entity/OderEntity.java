package com.example.webSale.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "dbo",name = "oder")
@Getter
@Setter
public class OderEntity extends BaseEntity implements Serializable {
    @Column(name = "oder_date")
    private Date oderDate;

    @Column(name = "address")
    private String address;

}
