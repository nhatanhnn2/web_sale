package com.example.webSale.repository;

import com.example.webSale.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long>, JpaSpecificationExecutor<UsersEntity> {
    Optional<UsersEntity> findByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByEmail(String email);

}
