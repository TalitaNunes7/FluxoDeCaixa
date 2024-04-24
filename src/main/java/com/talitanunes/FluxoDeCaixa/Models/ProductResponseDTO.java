package com.talitanunes.FluxoDeCaixa.Models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseDTO {

    private Long id;

    private String descriptionCategory;

    private String name;

    private BigDecimal saleValue;

    private BigDecimal purchasePrice;

    private String entryDate;

    private String productDescription;

    private Long quantity;

    private Long barcode;

    public ProductResponseDTO(){

    }

    public ProductResponseDTO(ProductRequestDTO product){
        this.id = product.getId();
        this.descriptionCategory = product.getCategory().getDescription();
        this.name = product.getName();
        this.saleValue =  product.getSaleValue();
        this.purchasePrice = product.getPurchasePrice();
        this.entryDate = product.getEntryDate();
        this.productDescription = product.getProductDescription();
        this.quantity = product.getQuantity();
        this.barcode = product.getBarcode();
    }

}
