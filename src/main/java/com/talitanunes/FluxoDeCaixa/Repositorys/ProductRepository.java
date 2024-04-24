package com.talitanunes.FluxoDeCaixa.Repositorys;

import com.talitanunes.FluxoDeCaixa.Models.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    ProductEntity findByBarcode(Long barcode);
    @Query("SELECT p FROM Product p WHERE p.category.id = :idCategory")
List<ProductEntity> browseProductByCategory(Long idCategory);
}

// estudar sql básico
// como fazer uma query no repositório do jpa com spring boot




                                                            //  exemplo de código
//public class OrdenacaoListaExemplo {
//    public static void main(String[] args) {
//        List<Integer> numeros = new ArrayList<>();
//        numeros.add(5);
//        numeros.add(2);
//        numeros.add(9);
//        numeros.add(1);
//        numeros.add(7);
//
//        Collections.sort(numeros); // Ordenação crescente
//        System.out.println("Lista ordenada em ordem crescente: " + numeros);
//
//        Collections.reverse(numeros); // Ordenação decrescente
//        System.out.println("Lista ordenada em ordem decrescente: " + numeros);
//    }
//}