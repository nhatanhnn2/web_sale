package com.example.webSale.repository;

import com.example.webSale.entity.Cart;
import com.example.webSale.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
