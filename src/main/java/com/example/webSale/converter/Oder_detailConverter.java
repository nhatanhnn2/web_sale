package com.example.webSale.converter;

import com.example.webSale.dto.Oder_detailDTO;
import com.example.webSale.dto.RoleDTO;
import com.example.webSale.entity.Oder_detail;
import com.example.webSale.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class Oder_detailConverter {

    public Oder_detailDTO toDTO(Oder_detail oder_detail){
        Oder_detailDTO dto = new Oder_detailDTO();
        dto.setId(oder_detail.getId());
        dto.setPrice(oder_detail.getPrice());
        dto.setQuantity(oder_detail.getQuantity());
        return dto;
    }

    public Oder_detail toEntity(Oder_detailDTO dto){
      Oder_detail oder_detail = new Oder_detail();
      oder_detail.setId(dto.getId());
      oder_detail.setPrice(dto.getPrice());
      oder_detail.setQuantity(dto.getQuantity());
      return oder_detail;
    }
}
