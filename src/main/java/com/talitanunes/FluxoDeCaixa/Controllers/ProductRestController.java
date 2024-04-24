package com.talitanunes.FluxoDeCaixa.Controllers;

import com.talitanunes.FluxoDeCaixa.Models.*;
import com.talitanunes.FluxoDeCaixa.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fdc")
@Validated
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@PostMapping
	@Validated
	public ResponseEntity<String> registerProduct(@RequestBody ProductRequestDTO product) {
		try {
			productService.saveProducts(product);
			return new ResponseEntity<>(MessageApplication.PRODUCT_SAVED_SUCCESSFULLY, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
    @GetMapping("/{barcode}")
	public ResponseEntity<ProductResponse> SearchProductByBarcode(@PathVariable Long barcode){
			ProductResponse response = productService.searchByBarcode(barcode);
			if(response != null) {
				return ResponseEntity.ok(response);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	@GetMapping
	public ResponseEntity<ProductResponse> searchForProductCategoryAndSort(@RequestParam(value = "sort") String sort, @RequestParam("idCategory") Long idCategory){
			try {
				List<ProductResponseDTO> list = productService.browseProductByCategory(sort , idCategory).getProducts();
				return new ResponseEntity<>(new ProductResponse(list), HttpStatus.OK);
			} catch (Exception e){
				ErrorDTO error = new ErrorDTO(TypeErrorAPI.UNEXPECTED_ERROR, MessageApplication.USER_ERROR);// Modificar
				return new ResponseEntity<>(new ProductResponse(error), HttpStatus.BAD_REQUEST);
			}
		}
	}



