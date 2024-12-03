package com.example.webSale.repository;

import com.example.webSale.entity.Category;
import com.example.webSale.entity.Group_category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
