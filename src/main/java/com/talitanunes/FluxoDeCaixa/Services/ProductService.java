package com.talitanunes.FluxoDeCaixa.Services;

import com.talitanunes.FluxoDeCaixa.Controllers.ErrorDTO;
import com.talitanunes.FluxoDeCaixa.Controllers.ProductResponse;
import com.talitanunes.FluxoDeCaixa.Mapper.ConvertProduct;
import com.talitanunes.FluxoDeCaixa.Models.*;
import com.talitanunes.FluxoDeCaixa.Repositorys.CategoriesRepository;
import com.talitanunes.FluxoDeCaixa.Repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoriesRepository categoriesRepository;
	@Autowired
	private CategoriesService categoriesService;


	public void saveProducts(ProductRequestDTO product) throws Exception {
		validatesDTO(product);
		categoriesService.validatesCategories(product.getCategoryId());
		ProductEntity entity = new ProductEntity(product);
		productRepository.save(entity);

	}

	private void validatesDTO(ProductRequestDTO product) throws Exception {
		boolean isNull = product.getCategoryId() == null ||
				product.getName().trim().isEmpty() ||
				product.getSaleValue() == null ||
				product.getPurchasePrice() == null ||
				product.getEntryDate().trim().isEmpty() ||
				product.getProductDescription().trim().isEmpty() ||
				product.getQuantity() == null ||
				product.getBarcode() == null;
		if (isNull) {
			ErrorDTO error = new ErrorDTO(TypeErrorAPI.VALIDATION_ERROR, MessageApplication.USER_ERROR);
			throw new Exception(String.valueOf(error));  // modificação obrigatoria pois não está mostrando ErrorDTO
		}
	}

	public ProductResponse searchByBarcode(Long barcode) {
		ProductRequestDTO productRequestDTO = ProductRequestDTO.fromDTO(productRepository.findByBarcode(barcode));
		if (productRequestDTO == null) {
			ErrorDTO error = new ErrorDTO(TypeErrorAPI.VALIDATION_ERROR, MessageApplication.PRODUCT_NOT_EXISTING +". "+ MessageApplication.USER_ERROR);
			return new ProductResponse(error);
		}
		CategoriesEntity category = categoriesRepository.findById((productRequestDTO.getCategoryId()))
				.orElseThrow(() -> new NoSuchElementException(MessageApplication.CATEGORY_ID_NOT_EXISTING));
		ProductResponseDTO fromResponse = new ProductResponseDTO(productRequestDTO);
		return new ProductResponse(fromResponse);
	}

	public ProductResponse browseProductByCategory(String sort, Long idCategory) throws Exception {
		categoriesService.validatesCategories(idCategory);
		List<ProductEntity> listOfProducts = productRepository.browseProductByCategory(idCategory);
		if ("decrescente".equals(sort)) {
			listOfProducts.sort(Comparator.comparing(ProductEntity::getEntryDate).reversed());
			List<ProductResponseDTO> listOfProductsByCategory = ConvertProduct.entitiesToDTOs(listOfProducts);
			return new ProductResponse(listOfProductsByCategory);
		} else if ("cresccente".equals(sort)) {
			listOfProducts.sort(Comparator.comparing(ProductEntity::getEntryDate));
			List<ProductResponseDTO> listOfProductsByCategory = ConvertProduct.entitiesToDTOs(listOfProducts);
			return new ProductResponse(listOfProductsByCategory);
		} else {
			ErrorDTO error = new ErrorDTO(TypeErrorAPI.UNEXPECTED_ERROR, "O erro ainda não pôde ser reconhecido.");
			return new ProductResponse(error);
		}

	}

}
