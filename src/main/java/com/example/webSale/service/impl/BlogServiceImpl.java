package com.example.webSale.service.impl;

import com.example.webSale.converter.UsersConverter;
import com.example.webSale.dto.BlogDTO;
import com.example.webSale.dto.ResponseDTO;
import com.example.webSale.dto.UsersDTO;
import com.example.webSale.entity.BlogEntity;
import com.example.webSale.entity.UsersEntity;
import com.example.webSale.repository.BlogRepository;
import com.example.webSale.repository.RoleRepository;
import com.example.webSale.repository.UsersRepository;
import com.example.webSale.repository.specification.BlogSpecification;
import com.example.webSale.repository.specification.UserSpecification;
import com.example.webSale.service.BlogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseDTO<BlogDTO> getAllBlog(BlogDTO dto) {
        PageRequest pageRequest = PageRequest.of(dto.getPage() - 1,dto.getPageSize(), Sort.by("id").descending());
        Page<BlogEntity> pageBlog = blogRepo.findAll(BlogSpecification.filterblog(dto),pageRequest);
        List<BlogDTO> dtos = pageBlog.getContent().stream()
                .map(entity -> modelMapper.map(entity,BlogDTO.class))
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setLimit(dto.getPageSize());
        responseDTO.setTotalItem((int)pageBlog.getTotalElements());
        responseDTO.setTotalPage((int)Math.ceil((double)pageBlog.getTotalElements() / responseDTO.getLimit()));
        responseDTO.setPage(dto.getPage());
        responseDTO.setListData(dtos);
        return responseDTO;
    }

    @Override
    public BlogDTO findById(Long id) {
        BlogEntity blogEntity = blogRepo.findById(id).orElseThrow(() -> new NotFoundException("Blog not found"));
        BlogDTO dto = modelMapper.map(blogEntity, BlogDTO.class);
        return dto;
    }
}
