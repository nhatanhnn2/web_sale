package com.example.webSale.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(schema = "dbo",name = "comment")
@Getter
@Setter
public class CommentEntity extends BaseEntity implements Serializable {
    @Column(name = "content")
    private String content;

}
