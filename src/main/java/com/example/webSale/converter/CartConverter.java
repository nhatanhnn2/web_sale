package com.example.webSale.converter;

import com.example.webSale.dto.CartDTO;
import com.example.webSale.dto.CategoryDTO;
import com.example.webSale.entity.Cart;
import com.example.webSale.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

    public CartDTO toDTO(Cart cart){
        CartDTO dto = new CartDTO();
        dto.setId(cart.getId());
        dto.setAdd_date(cart.getAdd_date());
        return dto;
    }

    public Cart toEntity(CartDTO dto){
        Cart cart = new Cart();
        cart.setId(dto.getId());
        cart.setAdd_date(dto.getAdd_date());
        return cart;
    }
}
