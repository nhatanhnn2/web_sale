package com.example.webSale.repository;

import com.example.webSale.entity.Blog;
import com.example.webSale.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
