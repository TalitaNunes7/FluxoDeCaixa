package com.talitanunes.FluxoDeCaixa.Mapper;

import com.talitanunes.FluxoDeCaixa.Models.ProductEntity;
import com.talitanunes.FluxoDeCaixa.Models.ProductResponseDTO;

import java.util.ArrayList;
import java.util.List;
public class ConvertProduct {  //converter

    public static ProductResponseDTO entityToDTO(ProductEntity entity){
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(entity.getId());
        dto.setDescriptionCategory(entity.getCategory().getDescription());
        dto.setName(entity.getName());
        dto.setSaleValue(entity.getSaleValue());
        dto.setPurchasePrice(entity.getPurchasePrice());
        dto.setEntryDate(entity.getEntryDate());
        dto.setProductDescription(entity.getProductDescription());
        dto.setQuantity(entity.getQuantity());
        dto.setBarcode(entity.getBarcode());
        return dto;
    }
    public static List<ProductResponseDTO> entitiesToDTOs(List<ProductEntity> entities){
        List<ProductResponseDTO> newListProductDTOs = new ArrayList<>();
        for (ProductEntity DTOs: entities){
            newListProductDTOs.add(entityToDTO(DTOs));
        }
        return newListProductDTOs;
    }
}
