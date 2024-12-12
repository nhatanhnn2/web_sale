package com.example.webSale.converter;

import com.example.webSale.dto.ProductDTO;
import com.example.webSale.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductDTO toDTO(ProductEntity productEntity){
        ProductDTO dto = new ProductDTO();
        dto.setId(productEntity.getId());
        dto.setName(productEntity.getName());
        dto.setPrice(productEntity.getPrice());
        dto.setQuantity(productEntity.getQuantity());
        dto.setCode(productEntity.getCode());
        dto.setDescription(productEntity.getDescription());
        dto.setImage(productEntity.getImage());
        dto.setPriceSale(productEntity.getPriceSale());
        return dto;
    }

    public ProductEntity toEntity(ProductDTO dto){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(dto.getId());
        productEntity.setName(dto.getName());
        productEntity.setPrice(dto.getPrice());
        productEntity.setQuantity(dto.getQuantity());
        productEntity.setCode(dto.getCode());
        productEntity.setDescription(productEntity.getDescription());
        productEntity.setImage(productEntity.getImage());
        productEntity.setPriceSale(productEntity.getPriceSale());
        return productEntity;
    }
}
