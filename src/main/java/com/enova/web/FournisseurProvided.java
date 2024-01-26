package com.enova.web;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/api/fournisseur")
@CrossOrigin("*")
public class FournisseurProvided {

	@Autowired
	private FournisseurService fournisseurService;

	@PostMapping("/")
	public int save(@RequestBody Fournisseur fournisseur) {
		return fournisseurService.save(fournisseur);
	}

	@GetMapping("/id/{id}")
	public Fournisseur findById(@PathVariable Long id) {
		return fournisseurService.findByIdFournisseur(id);
	}

	@Transactional
	@DeleteMapping("/id/{id}")
	public int deleteByRef(@PathVariable Long id) {
		return fournisseurService.deleteByIdFournisseur(id);
	}

	@GetMapping("/")
	public List<Fournisseur> findAll() {
		return fournisseurService.findAll();
	}
	
	
}
