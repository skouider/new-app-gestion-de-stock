package com.enova.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enova.beans.LigneCommande;

public interface LigneCommandeRepo extends JpaRepository<LigneCommande, Long>{
	List<LigneCommande> findByCommandeRefCommande(String ref);
	
    int deleteByCommandeRefCommande(String ref);
    List<LigneCommande> findByProduitIdProduit(Long id);
    LigneCommande findByProduitRefAndCommandeIdCommande(String ref, Long id);
    List<LigneCommande> findByCommandeIdCommande(Long idCommande);
    
}
