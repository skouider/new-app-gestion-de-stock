package com.enova.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enova.beans.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{

	Fournisseur findByNomFournisseur(String nomFournisseur);
	Fournisseur findByPrenomFournisseur(String prenomFournisseur);
	Fournisseur findByIdFournisseur(Long idFournisseur);
	
	int deleteByIdFournisseur(Long idFournisseur);
    
}
