package com.example.webSale.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class RoleDTO extends AbstractDto{
    private String name;
    private String code;
    List<Long> groupId = new ArrayList<>();
    List<Long> userId = new ArrayList<>();
}
