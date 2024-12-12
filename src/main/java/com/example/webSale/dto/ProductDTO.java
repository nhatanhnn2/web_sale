package com.example.webSale.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO extends AbstractDto{
    private String name;
    private float price;
    private int quantity;
    private String code;
    private String description;
    private float priceSale;
    private int status;
    private String image;
}
