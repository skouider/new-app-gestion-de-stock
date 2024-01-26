package com.enova.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enova.beans.Categorie;
import com.enova.beans.Produit;
import com.enova.service.facade.ProduitService;

@RestController
@RequestMapping("/api/produit")
public class ProduitProvidedApi {

	@Autowired
	private ProduitService produitService;

	@GetMapping("/ref/{ref}")
	public Produit findByRef(@PathVariable String ref) {
		return produitService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return produitService.deleteByRef(ref);
	}

	@GetMapping("/")
	public List<Produit> findAll() {
		return produitService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Categorie categorie) {
		return produitService.save(categorie, categorie.getProduits());
	}
	
	
}
