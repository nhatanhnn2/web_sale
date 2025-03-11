package com.example.webSale.service;

import com.example.webSale.dto.ResponseDTO;
import com.example.webSale.dto.UsersDTO;
import org.springframework.data.domain.Page;

import java.util.List;


public interface UsersService {

    ResponseDTO<UsersDTO> getAllUser(UsersDTO dto);

    UsersDTO update(UsersDTO dto)throws Exception;

    UsersDTO create(UsersDTO dto) throws Exception;

    UsersDTO findByEmail(String email);


}
