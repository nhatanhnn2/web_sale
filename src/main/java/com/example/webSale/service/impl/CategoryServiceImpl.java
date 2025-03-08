package com.example.webSale.service.impl;

import com.example.webSale.dto.CategoryDTO;
import com.example.webSale.dto.ResponseDTO;
import com.example.webSale.dto.UsersDTO;
import com.example.webSale.entity.CategoryEntity;
import com.example.webSale.entity.UsersEntity;
import com.example.webSale.repository.CategoryRepository;
import com.example.webSale.repository.specification.UserSpecification;
import com.example.webSale.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseDTO getAllCategory(CategoryDTO dto) {
        PageRequest pageRequest = PageRequest.of(dto.getPage() - 1,dto.getPageSize(), Sort.by("id").descending());
        Page<CategoryEntity> pageCategory;
        if (dto.getName() != null && !dto.getName().isEmpty()) {
            pageCategory = categoryRepo.findByName(dto.getName(), pageRequest);
        } else {
            pageCategory = categoryRepo.findAll(pageRequest);
        }
        List<CategoryDTO> dtos = pageCategory.getContent().stream()
                .map(entity -> modelMapper.map(entity,CategoryDTO.class))
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setLimit(dto.getPageSize());
        responseDTO.setTotalItem((int)pageCategory.getTotalElements());
        responseDTO.setTotalPage((int)Math.ceil((double)pageCategory.getTotalElements() / responseDTO.getLimit()));
        responseDTO.setPage(dto.getPage());
        responseDTO.setListData(dtos);
        return responseDTO;
    }

    @Override
    public CategoryDTO create(CategoryDTO dto) throws Exception {
        checkDuplicate(dto);
        CategoryEntity entity = modelMapper.map(dto, CategoryEntity.class);
        categoryRepo.save(entity);
        return dto;
    }

    @Override
    public CategoryDTO update(CategoryDTO dto) throws Exception {
        CategoryEntity entity = categoryRepo.findById(dto.getId()).get();
        checkDuplicate(dto);
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        categoryRepo.save(entity);
        return dto;
    }



    private void checkDuplicate(CategoryDTO dto) throws Exception{
        if (checkDuplicateName(dto.getName())){
            throw new Exception("Name đã tồn tại");
        }
    }

    private boolean checkDuplicateName(String name) {
        Page<CategoryEntity> entity = categoryRepo.findByName(name, Pageable.unpaged());
        if (!Objects.isNull(entity)){
           return true ;
        }else {
            return false;
        }
    }


}
