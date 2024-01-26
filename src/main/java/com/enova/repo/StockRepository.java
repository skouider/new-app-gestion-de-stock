package com.enova.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enova.beans.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

	Stock findByProduitRef(String ref);

	Stock findByProduitIdProduit(Long id);
	int deleteByIdStock(Long idStock);
}
