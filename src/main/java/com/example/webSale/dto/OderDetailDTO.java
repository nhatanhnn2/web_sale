package com.example.webSale.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OderDetailDTO extends AbstractDto{
    private int quantity;
    private float price;
}
