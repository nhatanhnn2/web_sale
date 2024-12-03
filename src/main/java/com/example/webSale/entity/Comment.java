package com.example.webSale.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(schema = "dbo",name = "comment")
@Getter
@Setter
public class Comment extends BaseEntity implements Serializable {
    @Column(name = "content")
    private String content;

}
