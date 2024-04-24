package com.talitanunes.FluxoDeCaixa.Services;

import com.talitanunes.FluxoDeCaixa.Controllers.ErrorDTO;
import com.talitanunes.FluxoDeCaixa.Models.CategoriesEntity;
import com.talitanunes.FluxoDeCaixa.Models.MessageApplication;
import com.talitanunes.FluxoDeCaixa.Models.TypeErrorAPI;
import com.talitanunes.FluxoDeCaixa.Repositorys.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriesService {

	@Autowired
	private CategoriesRepository categoriesRepository;


	public void validatesCategories(Long id) throws Exception {
		Optional<CategoriesEntity> categories = categoriesRepository.findById(id);
		if (categories.isEmpty())
			throw new Exception();
		new ErrorDTO(TypeErrorAPI.VALIDATION_ERROR, MessageApplication.CATEGORY_ID_NOT_EXISTING);
		// modificação obrigatoria pois não está mostrando ErrorDTO
	}

	public void salvarCategoria(CategoriesEntity categoria) {
		if (categoria.getDescription() != null && !categoria.getDescription().isEmpty()) {
			if (categoria.getUnitOfMeasure() != null && !categoria.getUnitOfMeasure().isEmpty()) {
				categoriesRepository.save(categoria);
			}
		}

	}

}