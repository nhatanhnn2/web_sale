package com.example.webSale.service.impl;

import com.example.webSale.constants.Constant;
import com.example.webSale.converter.UsersConverter;
import com.example.webSale.dto.UsersDTO;
import com.example.webSale.entity.RoleEntity;
import com.example.webSale.entity.UsersEntity;
import com.example.webSale.repository.RoleRepository;
import com.example.webSale.repository.UsersRepository;
import com.example.webSale.service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepo;
    @Autowired
    private UsersConverter converter;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<UsersDTO> getAllUser() {
//        List<UsersDTO> usersDTOList = usersRepo.findAll().stream().map(item -> converter.toDTO(item)).collect(Collectors.toList());
        List<UsersDTO> usersDTOS = new ArrayList<>();
        List<UsersEntity> users = usersRepo.findAll();
        for(UsersEntity item : users){
            UsersDTO dto = converter.toDTO(item);
            usersDTOS.add(dto);
        }
        return usersDTOS;
    }

    @Override
    public void save(UsersDTO dto) {
//        usersRepo.save
    }

    @Override
    @Transactional
    public UsersDTO create(UsersDTO dto) throws Exception {
        if (checkDuplicateEmail(dto.getEmail())){
            throw new Exception("Email đã tồn tại");
        }
        if (checkDuplicatePhone(dto.getPhone())){
            throw new Exception("Sdt đã tồn tại");
        }

        UsersEntity entity = modelMapper.map(dto,UsersEntity.class);
        entity.setPassword(passwordEncoder.encode(Constant.defaultPassword));
        RoleEntity roleEntity = roleRepository.findById(dto.getRoleId()).get();
        entity.setRoleId(roleEntity);
        usersRepo.save(entity);
        return  dto;

//        return converter.toDTO(usersRepo.save(converter.toEntity(dto)));
    }

    @Override
    public UsersDTO findByEmail(String email) {
        UsersEntity usersEntity = usersRepo.findByEmail(email);
        return modelMapper.map(usersEntity,UsersDTO.class);
    }

    private Boolean checkDuplicateEmail(String email){
        UsersEntity entity = usersRepo.findByEmail(email);
        if (!Objects.isNull(entity)){
            return true;
        }else {
            return false;
        }

    }

    private Boolean checkDuplicatePhone(String phone){
        UsersEntity entity = usersRepo.findByPhone(phone);
        if (!Objects.isNull(entity)){
            return true;
        }else {
            return false;
        }

    }


}
