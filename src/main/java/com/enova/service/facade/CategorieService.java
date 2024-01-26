package com.enova.service.facade;

import com.enova.beans.Categorie;

public interface CategorieService {

	Categorie findByNom(String nom);
	int save(Categorie categories);
}
