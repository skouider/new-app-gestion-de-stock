package com.enova.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enova.beans.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

	Commande findByRefCommande(String ref);
	int deleteByRefCommande(String ref);
}
