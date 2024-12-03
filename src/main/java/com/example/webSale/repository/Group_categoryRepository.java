package com.example.webSale.repository;

import com.example.webSale.entity.Group_category;
import com.example.webSale.entity.Group_permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Group_categoryRepository extends JpaRepository<Group_category, Long> {

}
