package com.example.webSale.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDTO<T> {
    private Integer page;
    private Integer limit;
    private Integer totalPage;
    private Integer totalItem;
    private List<T> listData;
}
