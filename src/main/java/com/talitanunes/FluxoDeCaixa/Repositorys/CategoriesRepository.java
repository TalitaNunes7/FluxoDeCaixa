package com.talitanunes.FluxoDeCaixa.Repositorys;

import com.talitanunes.FluxoDeCaixa.Models.CategoriesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends CrudRepository<CategoriesEntity, Long> {

}
