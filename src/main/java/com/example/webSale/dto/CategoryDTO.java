package com.example.webSale.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDTO extends AbstractDto{
    private String name;
    private int status;
}
