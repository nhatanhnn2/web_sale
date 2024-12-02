package com.example.webSale.repository;

import com.example.webSale.entity.Oder;
import com.example.webSale.entity.Oder_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OderRepository extends JpaRepository<Oder, Long> {

}
