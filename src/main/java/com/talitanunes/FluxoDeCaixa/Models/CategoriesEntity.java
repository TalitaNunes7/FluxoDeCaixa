package com.talitanunes.FluxoDeCaixa.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "Categories")
public class CategoriesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",unique = true)
	private Long id;

	@Column(unique = true)
	private String description; // decrição

	private String unitOfMeasure;  //unidade de medida
	public CategoriesEntity() {}
	public CategoriesEntity(Long id) {
		this.id = id;
	}
}
