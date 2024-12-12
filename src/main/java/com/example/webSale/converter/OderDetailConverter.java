package com.example.webSale.converter;

import com.example.webSale.dto.OderDetailDTO;
import com.example.webSale.entity.OderDetailEntity;
import org.springframework.stereotype.Component;

@Component
public class OderDetailConverter {

    public OderDetailDTO toDTO(OderDetailEntity oderDetailEntity){
        OderDetailDTO dto = new OderDetailDTO();
        dto.setId(oderDetailEntity.getId());
        dto.setPrice(oderDetailEntity.getPrice());
        dto.setQuantity(oderDetailEntity.getQuantity());
        return dto;
    }

    public OderDetailEntity toEntity(OderDetailDTO dto){
        OderDetailEntity oderDetailEntity = new OderDetailEntity();
        oderDetailEntity.setId(dto.getId());
        oderDetailEntity.setPrice(dto.getPrice());
        oderDetailEntity.setQuantity(dto.getQuantity());
        return oderDetailEntity;
    }
}
