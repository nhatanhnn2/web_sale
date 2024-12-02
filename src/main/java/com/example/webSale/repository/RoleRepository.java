package com.example.webSale.repository;

import com.example.webSale.entity.Role;
import com.example.webSale.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
