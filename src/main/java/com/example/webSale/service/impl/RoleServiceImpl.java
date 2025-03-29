package com.example.webSale.service.impl;

import com.example.webSale.dto.RoleDTO;
import com.example.webSale.entity.GroupPermissionEntity;
import com.example.webSale.entity.PermissionEntity;
import com.example.webSale.entity.RoleEntity;
import com.example.webSale.repository.RoleRepository;
import com.example.webSale.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RoleDTO> getAllRole() {
       return roleRepo.findAll()
                .stream()
                .map(roleEntity1 -> modelMapper.map(roleEntity1, RoleDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public void save(RoleDTO dto) {

    }

    @Override
    public List<String> findAllPermissionByRole(Long roleId) {
        Set<String> permission = new HashSet<>();
        RoleEntity roleEntity = roleRepo.findById(roleId).get();
        permission.add(roleEntity.getCode());
        for (GroupPermissionEntity groupPermissionEntity : roleEntity.getGroupPmEntities()){
            permission.add(groupPermissionEntity.getCode());
            for (PermissionEntity permissionEntity : groupPermissionEntity.getPermissionEntities()){
                permission.add(permissionEntity.getCode());
            }
        }
        return permission.stream().collect(Collectors.toList());
    }
}
