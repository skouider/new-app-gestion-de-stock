package com.enova.service.facade;

import java.util.List;

import com.enova.beans.Commande;


public interface CommandeService {

	int save(Commande commande);

	Commande findByRef(String ref);

	int deleteByRef(String ref);

	List<Commande> findAll();

	int calculQuantitéReceptionne(Commande commande);

	int update(Commande commande);

	
	
}
