package com.example.webSale.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "dbo",name = "blog")
@Getter
@Setter
public class BlogEntity extends BaseEntity implements Serializable {
    @Column(name = "content")
    private String content;

    @Column(name = "description")
    private String description;
}
