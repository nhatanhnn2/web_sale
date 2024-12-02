package com.example.webSale.converter;

import com.example.webSale.dto.OderDTO;
import com.example.webSale.dto.Oder_detailDTO;
import com.example.webSale.entity.Oder;
import com.example.webSale.entity.Oder_detail;
import org.springframework.stereotype.Component;

@Component
public class OderConverter {

    public OderDTO toDTO(OderDTO oderDTO){
        OderDTO dto = new OderDTO();
        dto.setId(oderDTO.getId());
        dto.setOder_date(oderDTO.getOder_date());
        dto.setAdderss(oderDTO.getAdderss());
        return dto;
    }

    public Oder toEntity(Oder dto){
      Oder oder = new Oder();
      oder.setId(dto.getId());
      oder.setOder_date(dto.getOder_date());
      oder.setAdderss(dto.getAdderss());
      return oder;
    }
}
