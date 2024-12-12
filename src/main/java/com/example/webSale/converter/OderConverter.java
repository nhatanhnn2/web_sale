package com.example.webSale.converter;

import com.example.webSale.dto.OderDTO;
import com.example.webSale.entity.OderEntity;
import org.springframework.stereotype.Component;

@Component
public class OderConverter {

    public OderDTO toDTO(OderDTO oderDTO){
        OderDTO dto = new OderDTO();
        dto.setId(oderDTO.getId());
        dto.setOderDate(oderDTO.getOderDate());
        dto.setAddress(oderDTO.getAddress());
        return dto;
    }

    public OderEntity toEntity(OderEntity dto){
      OderEntity oderEntity = new OderEntity();
      oderEntity.setId(dto.getId());
      oderEntity.setOderDate(dto.getOderDate());
      oderEntity.setAddress(dto.getAddress());
      return oderEntity;
    }
}
