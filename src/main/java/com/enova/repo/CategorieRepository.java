package com.enova.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enova.beans.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{

	Categorie findByNomCategorie(String nom);
}
