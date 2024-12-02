package com.example.webSale.repository;

import com.example.webSale.entity.Permission;
import com.example.webSale.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
