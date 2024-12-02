package com.example.webSale.service;

import com.example.webSale.dto.RoleDTO;
import com.example.webSale.dto.UsersDTO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> getAllRole();

    void save(RoleDTO dto);
}
