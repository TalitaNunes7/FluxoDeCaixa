package com.talitanunes.FluxoDeCaixa.Controllers;

import com.talitanunes.FluxoDeCaixa.Models.CategoriesEntity;
import com.talitanunes.FluxoDeCaixa.Services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriesRestController {

	@Autowired
	private CategoriesService categoriesService;

	@PostMapping("/cadastrarCategoria")
	public ResponseEntity<String> cadastrarCategoria(@RequestBody CategoriesEntity categoria) {
		categoriesService.salvarCategoria(categoria);
		return new ResponseEntity<>("Cadastrada com sucesso", HttpStatus.OK);
	}

}
