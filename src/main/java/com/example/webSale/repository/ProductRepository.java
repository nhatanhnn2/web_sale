package com.example.webSale.repository;

import com.example.webSale.entity.Product;
import com.example.webSale.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
