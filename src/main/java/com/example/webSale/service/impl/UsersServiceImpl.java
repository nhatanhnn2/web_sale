package com.example.webSale.service.impl;

import com.example.webSale.converter.UsersConverter;
import com.example.webSale.dto.UsersDTO;
import com.example.webSale.entity.Users;
import com.example.webSale.repository.UsersRepository;
import com.example.webSale.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepo;
    @Autowired
    private UsersConverter converter;

    @Override
    public List<UsersDTO> getAllUser() {
//        List<UsersDTO> usersDTOList = usersRepo.findAll().stream().map(item -> converter.toDTO(item)).collect(Collectors.toList());
        List<UsersDTO> usersDTOS = new ArrayList<>();
        List<Users> users = usersRepo.findAll();
        for(Users item : users){
            UsersDTO dto = converter.toDTO(item);
            usersDTOS.add(dto);
        }
        return usersDTOS;
    }

    @Override
    public void save(UsersDTO dto) {
//        usersRepo.save
    }


}
