package com.example.webSale.service;

import com.example.webSale.dto.UsersDTO;

import java.util.List;

public interface UsersService {

    List<UsersDTO> getAllUser();

    void save(UsersDTO dto);
}
