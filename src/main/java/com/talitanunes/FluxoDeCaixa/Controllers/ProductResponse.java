package com.talitanunes.FluxoDeCaixa.Controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.talitanunes.FluxoDeCaixa.Models.ProductResponseDTO;
import lombok.Data;

import java.util.List;


@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
public class ProductResponse {

   private ProductResponseDTO product;
   private ErrorDTO error;
   private List<ProductResponseDTO> products;


    public ProductResponse(ProductResponseDTO responseReturn) {
        this.product = responseReturn;
    }

    public ProductResponse(ErrorDTO error) {
        this.error = error;
    }

    public ProductResponse(List<ProductResponseDTO> listProducts) {
        this.products = listProducts;
    }
}
