package com.example.webSale.service;

import com.example.webSale.dto.RoleDTO;
import com.example.webSale.dto.UsersDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    List<RoleDTO> getAllRole();

    void save(RoleDTO dto);

    List<String> findAllPermissionByRole(Long roleId);

}
