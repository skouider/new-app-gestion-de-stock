package com.enova.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enova.beans.Categorie;
import com.enova.service.facade.CategorieService;


@RestController
@RequestMapping("/api/categorie")
@CrossOrigin("*")
public class CategorieProvidedApi {

	@Autowired
	private CategorieService categorieService;

	@GetMapping("/{nom}")
	public Categorie findByNom(@PathVariable String nom) {
		return categorieService.findByNom(nom);
	}

	@PostMapping("/")
	public int save(@RequestBody Categorie categorie) {
		return categorieService.save(categorie);
	}
	
	
}
