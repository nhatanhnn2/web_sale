package com.example.webSale.api.admin;

import com.example.webSale.dto.CategoryDTO;

import com.example.webSale.dto.ResponseDTO;
import com.example.webSale.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api/category")
public class CategoryApi {
    @Autowired
    private CategoryService categoryService;

//    @PostMapping()
//    public CategoryDTO create(@RequestBody CategoryDTO categoryDTO) throws Exception{
//        return categoryService.create(categoryDTO);
//    }

    @PostMapping()
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO categoryDTO) throws Exception{
        return new ResponseEntity<>(categoryService.create(categoryDTO),HttpStatus.CREATED) ;
    }

//    @GetMapping()
//    public List<CategoryDTO> listCategory(){
//        return categoryService.getAllCategory();
//    }

    @PostMapping("/list")
    public ResponseEntity<ResponseDTO<CategoryDTO>> listCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.getAllCategory(categoryDTO), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO categoryDTO)throws Exception{
        return new ResponseEntity<>(categoryService.update(categoryDTO), HttpStatus.OK);
    }

}
