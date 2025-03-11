package com.example.webSale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthLoginDTO {

    private String message;

    private String jwt;

    private String redirectUrl;


}
