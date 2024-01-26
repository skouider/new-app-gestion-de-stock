package com.enova.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enova.beans.Commande;
import com.enova.beans.LigneCommande;
import com.enova.service.impl.LigneCommandeService;


@RestController
@RequestMapping("/stock-api/ligneCommande")
@CrossOrigin("*")
public class LigneCommandeProvided {

	@Autowired
	private LigneCommandeService ligneCommandeService;

	@PostMapping("/")
	public void save(Commande commande, List<LigneCommande> commandeItems) {
		ligneCommandeService.save(commande, commandeItems);
	}

	@GetMapping("/ref/{ref}")
	public List<LigneCommande> findByCommandeRef(@PathVariable Long id) {
		return ligneCommandeService.findByCommandeId(id);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByCommandeRef(String ref) {
		return ligneCommandeService.deleteByCommandeRef(ref);
	}
	
	
}
