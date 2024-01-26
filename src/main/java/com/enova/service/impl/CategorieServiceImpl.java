package com.enova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enova.beans.Categorie;
import com.enova.repo.CategorieRepository;
import com.enova.service.facade.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService{

	@Autowired
	private CategorieRepository categorieRepository;
	
	@Override
	public Categorie findByNom(String nom) {
		// TODO Auto-generated method stub
		return categorieRepository.findByNomCategorie(nom);
	}

	@Override
	public int save(Categorie categorie) {
         if(findByNom(categorie.getNomCategorie()) != null) {
        	 return -1;
         }
         
         categorieRepository.save(categorie);
         
		return 1;
	}
	
	
}
