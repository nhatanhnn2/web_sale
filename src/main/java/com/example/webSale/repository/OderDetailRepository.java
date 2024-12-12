package com.example.webSale.repository;

import com.example.webSale.entity.OderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OderDetailRepository extends JpaRepository<OderDetailEntity, Long> {

}
