package com.example.webSale.converter;

import com.example.webSale.dto.ProductDTO;
import com.example.webSale.dto.UsersDTO;
import com.example.webSale.entity.Product;
import com.example.webSale.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductDTO toDTO(Product product){
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setCode(product.getCode());
        dto.setDescription(product.getDescription());
        dto.setImage(product.getImage());
        dto.setPrice_sale(product.getPrice_sale());
        return dto;
    }

    public Product toEntity(ProductDTO dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setCode(dto.getCode());
        product.setDescription(product.getDescription());
        product.setImage(product.getImage());
        product.setPrice_sale(product.getPrice_sale());
        return product;
    }
}
