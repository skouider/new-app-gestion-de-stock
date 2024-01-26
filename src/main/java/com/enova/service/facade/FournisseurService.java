package com.enova.service.facade;

import java.util.List;

import com.enova.beans.Fournisseur;



public interface FournisseurService {

	int save(Fournisseur fournisseur);

	Fournisseur findByIdFournisseur(Long idFournisseur);

	int deleteByIdFournisseur(Long idFournisseur);

	List<Fournisseur> findAll();

	

}
