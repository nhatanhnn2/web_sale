package com.example.webSale.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "dbo",name = "blog")
@Getter
@Setter
public class Blog extends BaseEntity implements Serializable {
    @Column(name = "content")
    private String content;

    @Column(name = "description")
    private String description;
}
