package com.example.webSale.service.impl;

import com.example.webSale.constants.Constant;
import com.example.webSale.converter.UsersConverter;
import com.example.webSale.dto.ResponseDTO;
import com.example.webSale.dto.UsersDTO;
import com.example.webSale.entity.RoleEntity;
import com.example.webSale.entity.UsersEntity;
import com.example.webSale.repository.RoleRepository;
import com.example.webSale.repository.UsersRepository;
import com.example.webSale.repository.specification.UserSpecification;
import com.example.webSale.service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public ResponseDTO getAllUser(UsersDTO dto) {
        PageRequest pageRequest = PageRequest.of(dto.getPage() - 1,dto.getPageSize(), Sort.by("id").descending());
        Page<UsersEntity> pageUser = usersRepo.findAll(UserSpecification.filterUser(dto),pageRequest);
        List<UsersDTO> dtos = pageUser.getContent().stream()
                .map(entity -> modelMapper.map(entity,UsersDTO.class))
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setLimit(dto.getPageSize());
        responseDTO.setTotalItem((int)pageUser.getTotalElements());
        responseDTO.setTotalPage((int)Math.ceil((double)pageUser.getTotalElements() / responseDTO.getLimit()));
        responseDTO.setPage(dto.getPage());
        responseDTO.setListData(dtos);
//        List<UsersDTO> usersDTOList = usersRepo.findAll().stream().map(item -> converter.toDTO(item)).collect(Collectors.toList());
//        List<UsersDTO> usersDTOS = new ArrayList<>();
//        List<UsersEntity> users = usersRepo.findAll();
//        for(UsersEntity item : users){
//            UsersDTO dto = converter.toDTO(item);
//            usersDTOS.add(dto);
//        }
        return responseDTO;
    }

    @Override
    public UsersDTO update(UsersDTO dto) throws Exception{
        UsersEntity entity = usersRepo.findById(dto.getId()).get();
        if (!dto.getEmail().equals(entity.getEmail())){
            if (checkDuplicateEmail(dto.getEmail())){
                throw new Exception("Email đã tồn tại");
            }
        }
        if (!dto.getPhone().equals( entity.getPhone())){
            if (checkDuplicatePhone(dto.getPhone())){
                throw new Exception("Sdt đã tồn tại");
            }
        }

        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setName(dto.getName());
        entity.setGender(dto.getGender());
        entity.setStatus(dto.getStatus());
        RoleEntity roleEntity = roleRepository.findById(dto.getRoleId()).get();
        entity.setRoleId(roleEntity);
        usersRepo.save(entity);
        return dto;
    }

    @Override
    @Transactional
    public UsersDTO create(UsersDTO dto) throws Exception {
        checkDuplicate(dto);
        UsersEntity entity = modelMapper.map(dto,UsersEntity.class);
        entity.setPassword(passwordEncoder.encode(Constant.defaultPassword));
        RoleEntity roleEntity = roleRepository.findById(dto.getRoleId()).get();
        entity.setRoleId(roleEntity);
        usersRepo.save(entity);
        return  dto;
    }

    private void checkDuplicate(UsersDTO dto)throws Exception{
        if (checkDuplicatePhone(dto.getEmail())){
            throw new Exception("Email đã tồn tại");
        }
        if (checkDuplicatePhone(dto.getPhone())){
            throw new Exception("Sdt đã tồn tại");
        }
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
