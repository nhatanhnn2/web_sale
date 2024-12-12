package com.example.webSale.repository;

import com.example.webSale.entity.OderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OderRepository extends JpaRepository<OderEntity, Long> {

}
