package com.enova.service.facade;

import java.util.List;

import javax.transaction.Transactional;

import com.enova.beans.Categorie;
import com.enova.beans.Produit;

public interface IProduitService {

//	List<Produit> getProduits();
//	Produit findByRef(String ref);
//	void addProduit(Produit produit);
//	void deleteProduit(Long id);
	public int save(Categorie categorie, List<Produit> produits);
	int saveToStock(Produit produit);
	Produit findById(Long id);
	void updateProduit(Produit produit);
	public Produit findByRef(String ref);
	List<Produit> findByCategorieId(Long id);
//	Produit findByStockIdStock(Long idStock);
	public int deleteByRef(String ref);

	public List<Produit> findAll();

	
}
