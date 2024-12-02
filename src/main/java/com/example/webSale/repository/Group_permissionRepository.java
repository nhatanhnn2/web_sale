package com.example.webSale.repository;

import com.example.webSale.entity.Group_permission;
import com.example.webSale.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Group_permissionRepository extends JpaRepository<Group_permission, Long> {

}
