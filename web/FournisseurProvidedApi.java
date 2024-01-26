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

import com.enova.beans.Fournisseur;
import com.enova.service.facade.FournisseurService;

@RestController
@RequestMapping
public class FournisseurProvidedApi {

	@Autowired
	private FournisseurService fournisseurService;

	@PostMapping("/")
	public int save(@RequestBody Fournisseur fournisseur) {
		return fournisseurService.save(fournisseur);
	}

	@GetMapping("/id/{idFournisseur}")
	public Fournisseur findByIdFournisseur(@PathVariable Long idFournisseur) {
		return fournisseurService.findByIdFournisseur(idFournisseur);
	}

	@DeleteMapping("/id/{idFournisseur}")
	public int deleteByIdFournisseur(@PathVariable Long idFournisseur) {
		return fournisseurService.deleteByIdFournisseur(idFournisseur);
	}

	@GetMapping("/")
	public List<Fournisseur> findAll() {
		return fournisseurService.findAll();
	}
	
	
}
