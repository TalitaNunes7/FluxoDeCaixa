package com.talitanunes.FluxoDeCaixa.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude( JsonInclude.Include.NON_NULL)
public class ProductRequestDTO {

    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoriesEntity category;

    private Long categoryId;

    private String name;

    private BigDecimal saleValue;

    private BigDecimal purchasePrice;

    private String entryDate;

    private String productDescription;

    private Long quantity;

    private Long barcode;
    public ProductRequestDTO(){

    }

    public ProductRequestDTO(ProductEntity entity){
        this.id = entity.getId();
        this.category = entity.getCategory();
        this.categoryId = entity.getCategory().getId();
        this.name = entity.getName();
        this.saleValue =  entity.getSaleValue();
        this.purchasePrice = entity.getPurchasePrice();
        this.entryDate = entity.getEntryDate();
        this.productDescription = entity.getProductDescription();
        this.quantity = entity.getQuantity();
        this.barcode = entity.getBarcode();
    }


    public static ProductRequestDTO fromDTO(ProductEntity byBarcode) {
        if(byBarcode!=null){
            return new ProductRequestDTO(byBarcode);
        }
        return null;
    }

}
