package com.example.webSale.repository;

import com.example.webSale.entity.CategoryEntity;
import com.example.webSale.entity.UsersEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    @Query("select c from CategoryEntity c where c.name like %?1%")
    Page<CategoryEntity> findByName(String name, Pageable pageable);
}
