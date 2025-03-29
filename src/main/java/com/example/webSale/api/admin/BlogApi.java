package com.example.webSale.api.admin;

import com.example.webSale.dto.BlogDTO;
import com.example.webSale.dto.ResponseDTO;
import com.example.webSale.dto.UsersDTO;
import com.example.webSale.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/blog")
public class BlogApi {
    @Autowired
    private BlogService blogService;
    @PostMapping("/list")
    public ResponseEntity<ResponseDTO<BlogDTO>> listBlog(@RequestBody BlogDTO blogDTO){
        return new ResponseEntity<>(blogService.getAllBlog(blogDTO), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public BlogDTO getId(@PathVariable Long id){
        return blogService.findById(id);
    }
}
