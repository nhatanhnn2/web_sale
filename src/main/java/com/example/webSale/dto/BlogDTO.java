package com.example.webSale.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BlogDTO extends AbstractDto{
    private String content;
    private String description;

}
