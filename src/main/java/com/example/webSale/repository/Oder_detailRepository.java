package com.example.webSale.repository;

import com.example.webSale.entity.Oder_detail;
import com.example.webSale.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Oder_detailRepository extends JpaRepository<Oder_detail, Long> {

}
