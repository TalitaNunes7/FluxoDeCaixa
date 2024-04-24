package com.talitanunes.FluxoDeCaixa.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "Product")
@JsonInclude( JsonInclude.Include.NON_NULL)
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private CategoriesEntity category;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private BigDecimal saleValue;

	@Column(nullable = false)
	private BigDecimal purchasePrice;

	@Column(nullable = false)
	private String entryDate;

	@Column(nullable = false)
	private String productDescription;

	@Column(nullable = false)
	private Long quantity;

	@Column(unique = true, nullable = false, updatable = false)
	private Long barcode;

	//public ProductEntity(List<ProductEntity> entities){
	//}

	//private List<ProductEntity> productsByCategory = new ArrayList<>();
	public ProductEntity(){

	}
	public ProductEntity(ProductRequestDTO product) {
		this.category = new CategoriesEntity(product.getCategoryId());
		this.name = product.getName();
		this.saleValue = product.getSaleValue();
		this.purchasePrice = product.getPurchasePrice();
		this.entryDate = product.getEntryDate();
		this.productDescription = product.getProductDescription();
		this.quantity = product.getQuantity();
		this.barcode = product.getBarcode();
	}

//	public static List<ProductEntity> entityForDTO(List<ProductEntity> idCategory) {
//		if(idCategory!=null) {
//			return idCategory;
//		}return null;
//	}

}
