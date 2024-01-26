package com.enova.service.facade;

import java.util.List;

import com.enova.beans.Produit;
import com.enova.beans.Stock;


public interface StockService {

//	int save(Produit produit, List<Stock> stocks);
	
	int save(Stock stock);
	Stock findByProduitId(Long id);

	Stock findById(Long id);
	
	int deleteById(Long idStock);

	List<Stock> findAll();

	int update(Stock stock);
	
	Stock findByProduitRef(String ref);

//	int save(Produit produit);

}
