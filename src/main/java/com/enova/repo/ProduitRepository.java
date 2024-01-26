package com.enova.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enova.beans.Produit;


public interface ProduitRepository extends JpaRepository<Produit, Long>{
      Produit findByIdProduit(Long idProduit);
	Produit findByRef(String ref);
	   int deleteByRef(String ref);
	   List<Produit> findByCategorieId(Long id);
}
